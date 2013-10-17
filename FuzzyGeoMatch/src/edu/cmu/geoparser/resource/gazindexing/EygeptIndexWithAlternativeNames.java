package edu.cmu.geoparser.resource.gazindexing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import edu.cmu.geoparser.io.GetReader;
import edu.cmu.geoparser.io.GetWriter;

public class EygeptIndexWithAlternativeNames {
	
	
	public static void main(String argv[]) throws Exception {
		
		GazIndexer gi = new GazIndexer();
		argv[0]="-write";
		argv[1] ="GeoNames/EG.txt";
		String mode = argv[0];
		if (mode.equals("-write")) {
			if (argv.length != 2)
				throw new Exception("Command line argument number wrong");
			BufferedReader br = GetReader.getUTF8FileReader(argv[1]);
			IndexWriter iw = GetWriter.getIndexWriter("EgIndex/");
			iw.deleteAll();
			gi.indexGazatteerWithOtherLanguages(br, iw);
			iw.optimize();
			iw.close();
			br.close();
		}
		if (mode.equals("-read")) {
			System.out.println("input id. Output basic information. For debugging.");
			// query first two fields.
			IndexSearcher is = GetReader.getIndexSearcher("GazIndex/");
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
			String line;
			while ((line = r.readLine()) != null) {

				long id;
				try {
					id = Long.parseLong(line);
				} catch (Exception e) {
					System.err.println("number wrong.");
					continue;
				}

				Query q = NumericRangeQuery.newLongRange("ID", id, id, true, true);
	
				long start = System.currentTimeMillis();
				TopDocs docs = is.search(q, 1);
				if (docs == null) {
					System.err.println("Not found.");
					continue;
				}
				if (docs.scoreDocs.length == 0) {
					System.err.println("Not found.");
					continue;
				}
				ScoreDoc sd = docs.scoreDocs[0];
				Document d = is.doc(sd.doc);
				long end = System.currentTimeMillis();
				System.out.println(d.get("ID"));
				System.out.println(d.get("ORIGIN"));
				System.out.println(d.get("LONGTITUDE") + " " + d.get("LATITUDE"));
				System.out.println("lookup time: " + (end - start));
			}
		}
	}
}
