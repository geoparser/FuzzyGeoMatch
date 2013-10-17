This is the fuzzy geo pair matching algorithm, using Machine Learning to classify candidate pairs as match or non-match.
This method is compared with edit distance method. The details are described in our paper:

Automatic gazetteer enrichment with user-geocoded data
Gautam Ganesh, Judith Gelernter, Hamsini Krishnakumar, Anna University, Wei Zhang
GeoCrowd '13


Before running the matching algorithm, please build the gazzeteer index first. The method for building that is described 
in the read me file in Geolocator.


The dependencies used are:

apache lucene v3.6.1
http://lucene.apache.org/core/

libsvm
http://www.csie.ntu.edu.tw/~cjlin/libsvm/

