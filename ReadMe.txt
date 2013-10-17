This is the fuzzy pair matching algorithm, using Machine Learning to classify candidate pairs as match or non-match.
Our SVM method can be compared to the edit distance method.  This tool could be generalized easily for different input 
file.  Now the input file format is {location phrase, lat/long) and the output file tells whether the input is match with
the gazetteer. 


The details are described in our paper:

Automatic gazetteer enrichment with user-geocoded data. 
Judith Gelernter, Gautam Ganesh, Hamsini Krishnakumar, Wei Zhang.  GeoCrowd '13


Before running the matching algorithm, please build the gazetteer index first. The method for building that is described 
in the ReadMe file in Geolocator.


The dependencies used are:

apache lucene v3.6.1
http://lucene.apache.org/core/

libsvm
http://www.csie.ntu.edu.tw/~cjlin/libsvm/

