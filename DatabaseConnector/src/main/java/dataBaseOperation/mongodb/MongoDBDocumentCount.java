package dataBaseOperation.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import configFileReader.ConfigFileReader;
import constants.LogImplementation;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;

public class MongoDBDocumentCount {

    private MongoDBDocumentCount() {

    }

    public static long getDocumentCount() {
        ConfigFileReader configFileReader = new ConfigFileReader();
        long count = 0;
        try (MongoClient mongoClient = new MongoClient(new MongoClientURI(configFileReader.driverUrl()))) {
            MongoDatabase database = mongoClient.getDatabase(configFileReader.dataBaseUser());

            boolean isCollectionPresent = database.listCollectionNames()
                    .into(new ArrayList<>())
                    .contains(configFileReader.getTableName());

            if (!isCollectionPresent) {
                LogImplementation.info("Collection not present. Initial count is 0.");
                return 0;
            }

            // Get the collection and count the documents
            MongoCollection<Document> collection = database.getCollection(configFileReader.getTableName());
            AggregateIterable<Document> result = collection.aggregate(Collections.singletonList(new Document("$count", "count")));
            count = result.first().get("count", Number.class).longValue();
            LogImplementation.info("Number of documents in the collection: " + count);
        } catch (Exception e) {
            LogImplementation.info(e.getMessage());
        }
        return count;
    }
}
