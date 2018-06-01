package com.example.springbootwithreactjs.database;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

import java.net.UnknownHostException;

public class MongoDB {

    private static MongoDB instance;

    //Key strings used for database purposes
    public static final String DB_NAME = "pageparser";
    public static final String COLLECTION_NAME = "roughparse";

    private DB db;
    private DBCollection coll;

    static public MongoDB getInstance(){
        if(instance == null){
            instance = new MongoDB();
        }
        return instance;
    }

    private MongoDB() throws UnknownHostException {
        Mongo mongo = new Mongo("localhost, 27017");
        db = mongo.getDB(DB_NAME);
        coll = db.getCollection(COLLECTION_NAME);
    }

    /*Have to add logic where if it is a about page, has a location, or has pictures
    this app will take that information and do as necessary for whatever is needed
    */
    //public void add(Page page)
}
