package com.example.springbootwithreactjs.database;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mongodb.*;

import java.net.UnknownHostException;

public class MongoDB {

    private static MongoDB instance;

    //Key strings used for database purposes
    public static final String DB_NAME = "applyboard";
    public static final String COLLECTION_NAME = "schoolsParsed";
    public static final String FINAL_PARSED = "finalSchoolsParsed";
    public static final String URL = "url";

    private DB db;
    private DBCollection coll;
    private DBCollection parsedColl;

    static public MongoDB getInstance(){
        if(instance == null){
            try {
                instance = new MongoDB();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
//test
    private MongoDB() throws UnknownHostException {
        Mongo mongo = new MongoClient("localhost");
        db = mongo.getDB(DB_NAME);
        coll = db.getCollection(COLLECTION_NAME);
        parsedColl = db.getCollection(FINAL_PARSED);
//        BasicDBObject temp = new BasicDBObject();
//        temp.append("hi", "helloWorld");
//        coll.insert(temp);
    }

    public void add(String page){
        BasicDBObject temp = new BasicDBObject();
        temp.append(URL, page);
        coll.insert(temp);
    }

    public void addBasicDBObject(BasicDBObject objectToInsert){
        coll.insert(objectToInsert);
    }

    public void addFinalPage(JsonObject jsonObj){
        JsonElement aboutData = jsonObj.get("aboutData");
        JsonElement aboutTitle = jsonObj.get("aboutTitle");
        JsonElement imageData = jsonObj.get("images");
        BasicDBObject temp = new BasicDBObject();
        temp.append("about", aboutData.toString());
        temp.append("aboutTitle", aboutTitle.toString());
        temp.append("images", imageData.toString());
        parsedColl.insert(temp);
    }
    /*Have to add logic where if it is a about page, has a location, or has pictures
    this app will take that information and do as necessary for whatever is needed
    */
    //public void add(Page page)
}
