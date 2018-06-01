package com.example.springbootwithreactjs.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

/**
 */
@RestController
public class PongController {

  @RequestMapping(value = "/pong", method = RequestMethod.GET)
  @CrossOrigin(origins = "http://localhost:3000") //TODO change me!
  public String pong() {
    //System.out.println("Received a ping from the server");
    return "pong";
  }

  @RequestMapping(value = "/urlsubmitted", method = RequestMethod.POST)
  @CrossOrigin(origins = "http://localhost:3000")
  public String urlSubmitted(WebRequest request){
    System.out.println(request.getParameter("suggest"));
   // System.out.println("reached this method" + firstName);
    return "Success";
  }
}
