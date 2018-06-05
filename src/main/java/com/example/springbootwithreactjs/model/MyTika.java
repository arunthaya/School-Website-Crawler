package com.example.springbootwithreactjs.model;

import com.mongodb.BasicDBObject;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.InputStream;
import java.net.URL;

public class MyTika {

    private static MyTika instance;
    private ParseContext context;
    private Metadata metadata;
    private Parser parser;

    public static MyTika getInstance(){
        if(instance == null){
            instance = new MyTika();
        }
        return instance;
    }

    private MyTika(){
        try{
            context = new ParseContext();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void store(URL url, BasicDBObject MongoDoc){
        try {
            parser = new AutoDetectParser();
            metadata = new Metadata();
            InputStream input = TikaInputStream.get(url, metadata);
            BodyContentHandler handler = new BodyContentHandler(2000000);
            parser.parse(input, handler, metadata, context);
            MongoDoc.append("titleofpage", metadata.get("title"));
            MongoDoc.append("contentofpage", handler.toString());
            input.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
