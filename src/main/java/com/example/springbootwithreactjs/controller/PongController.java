package com.example.springbootwithreactjs.controller;

import com.example.springbootwithreactjs.database.MongoDB;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

/**
 */
@RestController
public class PongController {

  @RequestMapping(value = "/urlsubmitted", method = RequestMethod.POST)
  @CrossOrigin(origins = "http://localhost:3000")
  public String urlSubmitted(WebRequest request){
    System.out.println(request.getParameter("suggest"));
   // System.out.println("reached this method" + firstName);
    MongoDB.getInstance().add(request.getParameter("suggest"));
    return "Success";
  }
}
