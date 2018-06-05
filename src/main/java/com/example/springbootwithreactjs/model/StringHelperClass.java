package com.example.springbootwithreactjs.model;

public class StringHelperClass {

    public static String[] schoolDictionary = {
            "school", "schools", "university", "college", "collegiate", "institute", "secondary", "elementary", "high-school", "highschool"
    };

    public static int validSchoolUrlChecker(String str){
        int counter = 0;
        String[] dic = str.toLowerCase().split("\\W+");
        for(String parsedString: dic){
            for(String dictionaryTerm: schoolDictionary){
                if(parsedString.equals(dictionaryTerm)){
                    counter++;
                }
            }
        }
        return counter;
    }
}
