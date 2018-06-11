package com.example.springbootwithreactjs.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StringHelperClass {

    private static StringHelperClass instance;
    private static ArrayList<String> schools;

    public static String[] SCHOOLDICTIONARY = {
            "school", "schools", "university", "college", "collegiate", "institute", "secondary", "elementary", "high-school", "highschool"
    };
    
    public static String[] ABOUTPAGEDICTIONARY = {
            "about", "about us", "facts", "who we are", "what we do", "welcome", "welcome to"
    };

    public static String[] CONTACTPAGEDICTIONARY = {
            "contact", "contact us", "address", "location", "telephone", "find us", "how to find us", "map"
    };

    static public StringHelperClass getInstance(){
        if(instance == null){
            instance = new StringHelperClass();
        }
        return instance;
    }

    private StringHelperClass(){
        schools = new ArrayList<>();
        try {
            readSchoolsFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readSchoolsFromFile() throws FileNotFoundException {

        ClassLoader classLoader = StringHelperClass.class.getClassLoader();
        File file = new File(classLoader.getResource("school_names/listofuniversities.txt").getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                schools.add(line);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------>printing out university names");
        for(String universityName: schools){
            System.out.println(universityName);
        }
        System.out.println("done printing out names <-");
    }

    public static int validSchoolUrlChecker(String str){
        if(str.equals(null))
            return 0;

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

    public static String schoolName(String str){
        if(str.equals(null)) {
            System.out.println("entered here, str is null line 90 string helper class");
            return null;
        }
        String[] dic = str.toLowerCase().split("\\.");
        System.out.println("printing out split query------>");
        for(String query: dic){
            System.out.println(query);
        }
        System.out.println("<--------------------------------");
        for(String parsedString: dic){
            for(String dictionaryTerm: schools){
                if(parsedString.contains(dictionaryTerm.toLowerCase())){
                    System.out.println(dictionaryTerm);
                    return dictionaryTerm;
                }
            }
        }
        return null;
    }


}
