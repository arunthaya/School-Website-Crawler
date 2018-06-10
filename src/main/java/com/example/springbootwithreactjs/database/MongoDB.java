package com.example.springbootwithreactjs.database;

import com.mongodb.*;

import java.net.UnknownHostException;

public class MongoDB {

    private static MongoDB instance;

    //Key strings used for database purposes
    public static final String DB_NAME = "pageparser";
    public static final String COLLECTION_NAME = "roughparse";
    public static final String URL = "url";

    private DB db;
    private DBCollection coll;

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

    /*Have to add logic where if it is a about page, has a location, or has pictures
    this app will take that information and do as necessary for whatever is needed
    */
    //public void add(Page page)
}
