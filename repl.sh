#!/bin/bash

breakchars="(){}[],^%$#@\"\";:''|\\"

#exec rlwrap -b $breakchars ... 
java -classpath target/:lib/\* jline.ConsoleRunner clojure.main
