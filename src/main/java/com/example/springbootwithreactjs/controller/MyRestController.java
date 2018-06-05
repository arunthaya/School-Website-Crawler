package com.example.springbootwithreactjs.controller;

import com.example.springbootwithreactjs.database.MongoDB;
import com.example.springbootwithreactjs.model.MyTika;
import com.mongodb.BasicDBObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.net.MalformedURLException;
import java.net.URL;

/**
 */
@RestController
public class MyRestController {

  @RequestMapping(value = "/urlsubmitted", method = RequestMethod.POST)
  @CrossOrigin(origins = "http://localhost:3000")
  public String urlSubmitted(WebRequest request){
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
    MyTika.getInstance().validSchoolUrl(url);
    return "Success";
  }
}
