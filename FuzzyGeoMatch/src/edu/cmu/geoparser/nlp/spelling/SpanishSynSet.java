package edu.cmu.geoparser.nlp.spelling;

import edu.cmu.geoparser.io.GetReader;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;

public class SpanishSynSet {

	int lineid;
	String toks;
	ArrayList<ArrayList<String>> list; // line number map to hashset
	HashMap<Integer,String> index;// string map to line number
	public SpanishSynSet(){
		list = new ArrayList<ArrayList<String>>();
		index = new HashMap<Integer,String>();
		lineid=0;
		toks=null;
	}
	public void Set(String filename)throws IOException{
		BufferedReader r = GetReader.getUTF8FileReader(filename);
		String line =null;
		while((line = r.readLine())!=null){
			line = line.split("//")[0];
			String[] toks = line.split(",.");
			for (String tok : toks)
			System.out.println(tok);
		}
	}
	public static void main(String argv[]) throws IOException{
		SpanishSynSet sss= new SpanishSynSet();
		sss.Set("synset.txt");
	}
}
