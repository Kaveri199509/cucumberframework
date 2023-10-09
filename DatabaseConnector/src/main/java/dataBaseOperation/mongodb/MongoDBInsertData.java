package dataBaseOperation.mongodb;

import com.mongodb.client.MongoCollection;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import constants.LogImplementation;
import dataBaseOperation.exception.DataBaseQueryException;
import org.bson.Document;
import org.example.MongoDbConnection;

import java.io.FileReader;
import java.io.IOException;

public class MongoDBInsertData {
    private MongoDBInsertData() {

    }

    public static long insertCSVFile(String csvFilePath) {

        MongoCollection<Document> collection = MongoDbConnection.setConnection();
        LogImplementation.info("collection = " + collection);
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] headers = reader.readNext(); // Assume first row contains headers
            long count = 0;
            String[] values;
            while ((values = reader.readNext()) != null) {
                Document document = new Document();
                for (int i = 0; i < headers.length && i < values.length; i++) {
                    document.append(headers[i], values[i]);
                }
                collection.insertOne(document);
                count++;
            }
            LogImplementation.info("Data inserted into MongoDB.");
            return count;
        } catch (CsvValidationException | IOException e) {
            throw new DataBaseQueryException(e.getMessage());
        }
    }

}