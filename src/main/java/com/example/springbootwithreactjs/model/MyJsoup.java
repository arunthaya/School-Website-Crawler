package com.example.springbootwithreactjs.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyJsoup {

    //Static variables
    private static MyJsoup instance;
    private static Map<String, String> altMapForImgs;

    public static JsonArray getImageArrayJson() {
        return imageArrayJson;
    }

    private static JsonArray imageArrayJson;

    public static ArrayList<String> getImages() {
        return images;
    }

    private static ArrayList<String> images;

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
        images = new ArrayList<>();
        imageArrayJson = new JsonArray();
    }

    public void storeImgAltInfo(String urlString){
        Document doc;
        try{
            doc = Jsoup.connect(urlString).get();
            //System.out.println("urlstring to try for storing images is: "+urlString);
//            String imgSelector = "img[src~=(?i)\\\\.(png|jpe?g|gif)]";
//            Elements imgs = doc.select(imgSelector);
            Elements imgs = doc.getElementsByTag("img");
            for(Element e: imgs){
                //System.out.println(e.toString());
                //altMapForImgs.put(e.attr("src"), e.attr("alt"));
                altMapForImgs.put(e.absUrl("src"), e.absUrl("alt"));
                String imageUrl = e.absUrl("src");
                String altUrl = e.absUrl("alt");
                if(imageUrl.endsWith(".jpg") || imageUrl.endsWith(".png") || imageUrl.endsWith(".jpeg")){
                    images.add(imageUrl);
                    JsonObject imageJson = new JsonObject();
                    imageJson.addProperty("url", imageUrl);
                    imageArrayJson.add(imageJson);
                }
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
                String paragraphChecker = paragraph.toString();
                if(paragraphChecker.contains("href") || paragraphChecker.contains("<a")) {
                    //System.out.println("skipping paragraph " + paragraph.toString());
                    continue;
                }
                //System.out.println("paragraph is: "+paragraph);
                //System.out.println("paragraph as a string is "+paragraph.toString());
                paragraphsOnPage += paragraph.text();
                String validSentence = paragraph.text();
                String[] words = validSentence.split(" ");
            }
        } catch(IOException e1){
            e1.printStackTrace();
        }
        //System.out.println("paragraphs on page is " + paragraphsOnPage);
        return paragraphsOnPage;
    }

    //Todo - add logic to grab images, and only the most relevant sentences for the about page
    public static Map<String, String> getUrlAltMapForImgs() {
        return altMapForImgs;
    }

}
