package com.example.springbootwithreactjs.model;

public class StringHelperClass {

    public static String[] SCHOOLDICTIONARY = {
            "school", "schools", "university", "college", "collegiate", "institute", "secondary", "elementary", "high-school", "highschool"
    };
    
    public static String[] ABOUTPAGEDICTIONARY = {
            "about", "about us", "facts", "who we are", "what we do", "welcome", "welcome to"
    };

    public static int validSchoolUrlChecker(String str){
        int counter = 0;
        String[] dic = str.toLowerCase().split("\\W+");
        for(String parsedString: dic){
            for(String dictionaryTerm: SCHOOLDICTIONARY){
                if(parsedString.equals(dictionaryTerm)){
                    counter++;
                }
            }
        }
        return counter;
    }

    public static int aboutPageChecker(String str){
        if(str == null)
            return 0;
        int counter = 0;
        String[] dic = str.toLowerCase().split("\\.");
        for(String parsedString: dic){
            for(String dictionaryTerm: ABOUTPAGEDICTIONARY){
                if(parsedString.contains(dictionaryTerm)){
                    counter++;
                }
            }
        }
        return counter;
    }

}
