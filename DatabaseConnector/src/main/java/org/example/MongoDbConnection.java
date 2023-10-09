package org.example;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import configFileReader.ConfigFileReader;
import org.bson.Document;

public class MongoDbConnection {

    private static final ConfigFileReader configFileReader = new ConfigFileReader();

    private MongoDbConnection() {
    }

    public static MongoCollection<Document> setConnection() {
        MongoClientURI mongoClientURI = new MongoClientURI(configFileReader.driverUrl());
        try (MongoClient mongoClient = new MongoClient(mongoClientURI)) {
            MongoDatabase database = mongoClient.getDatabase(configFileReader.dataBaseUser());
            return database.getCollection(configFileReader.getTableName());
        }
    }
}
