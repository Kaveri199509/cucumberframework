package dataBaseOperation.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import constants.LogImplementation;
import org.bson.Document;
import org.example.MongoDbConnection;

public class MongoDBDeleteData {

    private MongoDBDeleteData() {

    }

    public static long deleteData(String key, Object value) {
        MongoCollection<Document> collection = MongoDbConnection.setConnection();


        Document filter = new Document(key, value);
        DeleteResult deleteResult = collection.deleteOne(filter);
        long deletedCount = deleteResult.getDeletedCount();
        LogImplementation.info("Data deleted successfully for " + key + ": " + value);
        return deletedCount;
    }


}
