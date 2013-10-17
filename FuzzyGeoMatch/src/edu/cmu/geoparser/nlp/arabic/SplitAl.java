package edu.cmu.geoparser.nlp.arabic;

/** Script to normalize Arabic - TTS Version
* @author sjeblee@cs.cmu.edu
* Last modified: 20 June 2013
*
* $ java SplitAl inputfile outputfile
*/

import java.util.Scanner;
import java.io.*;

public class SplitAl{

public static void main(String[] args){

	if(args.length < 2){
		System.out.println("Usage: java SplitAl inputfile outputfile");
		System.exit(1);
	}

	try{
		Scanner infile = new Scanner(new FileReader(args[0]));
		FileWriter outfile = new FileWriter(args[1]);
		while(infile.hasNextLine()){
			String aline = infile.nextLine();	
                                String buffer = "";

				for(int x=0; x<aline.length(); x++){
					char c = aline.charAt(x);

					if(c == 'ا'){	//separate al (if at least 2 letters after al)
				 		if((aline.length() > x+3) && (aline.charAt(x+1) == 'ل')
						&& ( (x==0) || ((x>0) && (aline.charAt(x-1)==' ')) 
							|| ((x>1) && (aline.charAt(x-1)=='ب') && (aline.charAt(x-2)==' '))
							|| ((x>1) && (aline.charAt(x-1)=='^') && (aline.charAt(x-2)==' ')) )	
							//make sure it's the beginning of a word
						&& (!( (aline.charAt(x+2)=='ل') && ((aline.charAt(x+3)=='ه') || (aline.charAt(x+3)=='ي')) )))	{	
				 			//make sure the word is not Allah
							if((x>1) && (aline.charAt(x-1)=='ب')) //separate off ب
								buffer += " ";
							buffer += "ال ";
							x ++; //skip over laam
						}
						else
							buffer += 'ا';
					}//end if c is alif
 
					else buffer += Character.toString(c);
				}//end for

				buffer.trim();
				if(buffer.length() > 0)
                                        outfile.write(buffer + "\n");
                }//end while                             
		outfile.close();
		infile.close();
	}//end try
	catch(IOException e){
		System.out.println(e.getMessage());
	}

}//end main

	public static String split(String aline) {
		String buffer = "";

		for (int x = 0; x < aline.length(); x++) {
			char c = aline.charAt(x);

			if (c == 'ا') { // separate al (if at least 2 letters after
						// al)
				if ((aline.length() > x + 3)
						&& (aline.charAt(x + 1) == 'ل')
						&& ((x == 0) || ((x > 0) && (aline.charAt(x - 1) == ' '))
								|| ((x > 1) && (aline.charAt(x - 1) == 'ب') && (aline.charAt(x - 2) == ' '))
						// make sure it's the beginning of a word
						|| ((x > 1) && (aline.charAt(x - 1) == '^') && (aline.charAt(x - 2) == ' ')))
						// make sure the word is not Allah
						&& (!((aline.charAt(x + 2) == 'ل') && ((aline.charAt(x + 3) == 'ه') || (aline
								.charAt(x + 3) == 'ي'))))) {
					if ((x > 1) && (aline.charAt(x - 1) == 'ب')) // separate
													// off
													// ب
						buffer += " ";
					buffer += "ال ";
					x++; // skip over laam
				} else
					buffer += 'ا';
			}// end if c is alif

			else
				buffer += Character.toString(c);
		}// end for

		return buffer.trim();

	}
public static boolean containsArabic(String line){
	if((line.indexOf('ا') >= 0) ||
	(line.indexOf('ض') >= 0) ||
	(line.indexOf('ط') >= 0) ||
	(line.indexOf('ث') >= 0) ||
	(line.indexOf('ق') >= 0) ||
	(line.indexOf('ف') >= 0) ||
	(line.indexOf('غ') >= 0) ||
	(line.indexOf('ع') >= 0) ||
	(line.indexOf('ه') >= 0) ||
	(line.indexOf('خ') >= 0) ||
	(line.indexOf('ح') >= 0) ||
	(line.indexOf('ج') >= 0) ||
	(line.indexOf('د') >= 0) ||
	(line.indexOf('ش') >= 0) ||
	(line.indexOf('س') >= 0) ||
	(line.indexOf('ي') >= 0) ||
	(line.indexOf('ب') >= 0) ||
	(line.indexOf('ل') >= 0) ||
	(line.indexOf('ت') >= 0) ||
	(line.indexOf('ن') >= 0) ||
	(line.indexOf('م') >= 0) ||
	(line.indexOf('ك') >= 0) ||
	(line.indexOf('ء') >= 0) ||
	(line.indexOf('ر') >= 0) ||
	(line.indexOf('ﻻ') >= 0) ||
	(line.indexOf('ى') >= 0) ||
	(line.indexOf('ة') >= 0) ||
	(line.indexOf('و') >= 0) ||
	(line.indexOf('ز') >= 0) ||
	(line.indexOf('ظ') >= 0) ||
	(line.indexOf('ذ') >= 0) ||
	(line.indexOf('أ') >= 0) ||
	(line.indexOf('إ') >= 0) ||
	(line.indexOf('آ') >= 0) ||
	(line.indexOf('ﻷ') >= 0) ||
	(line.indexOf('؟') >= 0) )
		return true;
	else return false;
}

}







