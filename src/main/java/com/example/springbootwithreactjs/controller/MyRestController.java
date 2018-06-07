package com.example.springbootwithreactjs.controller;

import com.example.springbootwithreactjs.database.MongoDB;
import com.example.springbootwithreactjs.model.MyTika;
import com.mongodb.BasicDBObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 */
@RestController
public class MyRestController {

    @RequestMapping(value = "/urlsubmitted", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public boolean urlSubmitted(WebRequest request){
        System.out.println(request.getParameter("suggest"));
        BasicDBObject toInsert = new BasicDBObject();
        URL url = null;
        try{
            url = new URL(request.getParameter("suggest"));
        } catch(MalformedURLException e1){
            e1.printStackTrace();
        }
        toInsert.append(MongoDB.URL, request.getParameter("suggest"));
        //MongoDB.getInstance().addBasicDBObject(toInsert);
        return MyTika.getInstance().validSchoolUrl(url);
    }

    @RequestMapping(value = "/urlToParse", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public String urlParsed(WebRequest request){
        String aboutUsPage = "";
        System.out.println("length of aboutus page: " + aboutUsPage.length() + "aboutUsPage string before " + aboutUsPage);
        System.out.println("request coming in for Urltoparse is "+request.getParameter("urlToParse"));
        try {
            aboutUsPage = MyCrawlController.getInstance(request.getParameter("urlToParse")).crawl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("length of aboutus page: " + aboutUsPage.length() + " about us page after " + aboutUsPage + "");
        System.out.println("control flow returned to Java- Spring");
        return aboutUsPage;
    }

}
