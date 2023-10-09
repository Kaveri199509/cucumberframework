package dataBaseOperation.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import constants.LogImplementation;
import org.bson.Document;
import org.example.MongoDbConnection;

import java.util.List;
import java.util.Map;

public class MongoDBUpdateData {
    private MongoDBUpdateData() {

    }

    public static long updateData(String empIdToUpdate, List<Map<String, Object>> dataToUpdate) {
        MongoCollection<Document> collection = MongoDbConnection.setConnection();
        Document filter = new Document("empId", empIdToUpdate);
        Document update = new Document();
        for (Map<String, Object> updateList : dataToUpdate) {
            update.append("$set", new Document(updateList));
        }

        // Perform the update operation
        UpdateResult updateResult = collection.updateMany(filter, update);
        long modifiedCount = updateResult.getModifiedCount();
        if (modifiedCount > 0) {
            LogImplementation.info("Documents matched: " + updateResult.getMatchedCount());
            LogImplementation.info("Documents modified: " + modifiedCount);
        } else {
            LogImplementation.info("Documents not mofified: " + modifiedCount);
        }
        // Output the result
        return modifiedCount;
    }
}
