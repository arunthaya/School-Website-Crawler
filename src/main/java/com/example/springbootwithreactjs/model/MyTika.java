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
        System.out.println("entered MyTika and created an instance of it");
        try{
            context = new ParseContext();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String store(URL url, BasicDBObject MongoDoc){
        System.out.println("Url entered was: "+url);
        try {
            parser = new AutoDetectParser();
            metadata = new Metadata();
            InputStream input = TikaInputStream.get(url, metadata);
            BodyContentHandler handler = new BodyContentHandler(2000000);
            parser.parse(input, handler, metadata, context);
            MongoDoc.append("titleofpage", metadata.get("title"));
            MongoDoc.append("contentofpage", handler.toString());
            MongoDoc.append("metadata", metadata.toString());
            input.close();
            return metadata.get("title");
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean validSchoolUrl(URL url){
        try{
            parser = new AutoDetectParser();
            metadata = new Metadata();
            InputStream input = TikaInputStream.get(url, metadata);
            BodyContentHandler handler = new BodyContentHandler(2000000);
            parser.parse(input, handler, metadata, context);
            int urlParsed = StringHelperClass.validSchoolUrlChecker(url.toString());
            int titleParsed = StringHelperClass.validSchoolUrlChecker(metadata.get("title"));
            int metaParsed = StringHelperClass.validSchoolUrlChecker(metadata.toString());
            if(urlParsed > 0 || titleParsed > 0 || metaParsed > 0){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean validAboutUsPage(URL url){
        try{
            System.out.println("currently checking if it is about us page ");
            parser = new AutoDetectParser();
            metadata = new Metadata();
            InputStream input = TikaInputStream.get(url, metadata);
            BodyContentHandler handler = new BodyContentHandler(2000000);
            parser.parse(input, handler, metadata, context);
            int urlParsed = StringHelperClass.aboutPageChecker(url.toString());
            int titleParsed = StringHelperClass.aboutPageChecker(metadata.get("title"));
            int metaParsed = StringHelperClass.aboutPageChecker(metadata.toString());
            System.out.println("    the numbers are as follows: " + urlParsed + " " + titleParsed + " " +metaParsed);
            if(urlParsed > 0 || titleParsed > 0 || metaParsed > 0){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
