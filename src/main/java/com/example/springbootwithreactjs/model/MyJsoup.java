package com.example.springbootwithreactjs.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyJsoup {

    //Static variables
    private static MyJsoup instance;
    private static Map<String, String> altMapForImgs;

    static public MyJsoup getInstance(){
        if(instance == null){
            instance = new MyJsoup();
        }
        return instance;
    }
    /*add logic to grab urls for images and grab relevant paragraphs about the website and only grabbing paragraphs from the page
        checks the url for absolutes, and if it is an about page absolutely then it will grab all necessary information
    */
    private MyJsoup(){
        altMapForImgs = new HashMap<String, String>();
    }

    public void storeImgAltInfo(String urlString){
        Document doc;
        try{
            doc = Jsoup.connect(urlString).get();
            String imgSelector = "img[src~=(?i)\\\\.(png|jpe?g|gif)]";
            Elements imgs = doc.select(imgSelector);
            for(Element e: imgs){
                altMapForImgs.put(e.attr("src"), e.attr("alt"));
            }
        } catch(IOException e1){
            e1.printStackTrace();
        }
    }

    public String getParagraphSelector(String urlString){
        Document doc;
        String paragraphsOnPage = "";
        try{
            doc = Jsoup.connect(urlString).get();
            Elements paragraphs =  doc.select("p");
            for(Element paragraph: paragraphs){
                paragraphsOnPage += paragraph.text();
                System.out.println("paragraph is: "+paragraph);
            }
        } catch(IOException e1){
            e1.printStackTrace();
        }
        System.out.println("paragraphs on page is " + paragraphsOnPage);
        return paragraphsOnPage;
    }

    //Todo - add logic to grab images, and only the most relevant sentences for the about page
    public static Map<String, String> getUrlAltMapForImgs() {
        return altMapForImgs;
    }

}
