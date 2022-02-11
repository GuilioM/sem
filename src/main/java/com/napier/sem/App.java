package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.print.Doc;

public class App {
    public static void main(String[] args){
        //Connecting to MongoDB
        MongoClient mongoClient = new MongoClient("mongo-dbserver");

        //Get a db
        MongoDatabase db = mongoClient.getDatabase("mydb");

        //Get a collection from the db
        MongoCollection<Document> collection = db.getCollection("test");

        //Create Document doc to store
        Document doc = new Document("name","Guilio M")
                .append("class","Software Engineering Methods")
                .append("year", "2022")
                .append("result", new Document("CW", 95).append("EX", 85));

        //Add doc in collection
        collection.insertOne(doc);

        //Check doc in collection
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
    }
}
