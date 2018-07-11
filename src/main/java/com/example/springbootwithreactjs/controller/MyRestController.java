package com.example.springbootwithreactjs.controller;


import com.example.springbootwithreactjs.SpringBootWithReactJsApplication;
import com.example.springbootwithreactjs.model.MyTika;
import com.example.springbootwithreactjs.model.StringHelperClass;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 */
@RestController
public class MyRestController {

    private JsonArray schools;


    @RequestMapping(value = "/urlsubmitted", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public boolean urlSubmitted(WebRequest request){
        System.out.println(request.getParameter("suggest"));
        URL url = null;
        try{
            url = new URL(request.getParameter("suggest"));
        } catch(MalformedURLException e1){
            e1.printStackTrace();
        }
        return MyTika.getInstance().validSchoolUrl(url);
    }

    @RequestMapping(value = "/urltoparse", method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String urlParsed(WebRequest request){
        JsonObject responseObj = new JsonObject();
        //System.out.println("length of aboutus page: " + aboutUsPage.length() + "aboutUsPage string before " + aboutUsPage);
//        System.out.println("request coming in for Urltoparse is "+request.getParameter("urlToParse"));
//        try {
//            MyCrawlController toCrawl = new MyCrawlController(request.getParameter("urlToParse"));
//            toCrawl.crawl(responseObj);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //System.out.println("length of aboutus page: " + aboutUsPage.length() + " about us page after " + aboutUsPage + "");
//        System.out.println("control flow returned to Java- Spring");
        responseObj.addProperty("data", "hello");
        return responseObj.toString();
    }

    @RequestMapping(value = "/school_list", method = RequestMethod.GET)
    public String finalSchoolRetrieval(){
        return null;
    }

}
