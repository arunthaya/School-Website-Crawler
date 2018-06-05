package com.example.springbootwithreactjs.model;

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

    private MyJsoup(){
        altMapForImgs = new HashMap<String, String>();
    }
}
