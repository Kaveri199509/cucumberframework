package dataBaseOperation.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.opencsv.CSVReader;
import constants.LogImplementation;
import org.bson.Document;
import org.example.MongoDbConnection;

import java.io.FileReader;
import java.util.*;

public class MongoDBSelectData {

    static String csvFilePath = "C:\\Users\\lenovo\\Desktop\\QA-Automation-updated\\DatabaseConnector\\src\\test\\CsvFolder\\employee.csv";

    private MongoDBSelectData() {

    }

    public static boolean getAllCollection() {
        MongoCollection<Document> collection = MongoDbConnection.setConnection();
        // Query MongoDB collection
        List<String[]> csvData = readCSVFile(csvFilePath);
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            LogImplementation.info(document.toJson());
        }
        boolean b = checkCSVDataInMongoDB(csvData, documents);
        return b;
    }

    private static List<String[]> readCSVFile(String csvFilePath) {

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            return reader.readAll();
        } catch (Exception e) {
            LogImplementation.info(e.getMessage());
            return new ArrayList<>();
        }
    }

    private static boolean checkCSVDataInMongoDB(List<String[]> csvData, FindIterable<Document> documents) {
        // Create a set to store the unique values from CSV data
        Set<String> csvDataValues = new HashSet<>();
        boolean check = false;
        // Extract the unique values from the CSV data and store them in the set
        for (String[] row : csvData) {
            Collections.addAll(csvDataValues, row);
        }

        // Check if the values from the CSV data are present in the MongoDB documents
        for (Document document : documents) {

            String empName = document.getString("empName");
            String empId = document.getString("empId");
            String empSalary = document.getString("empSalary");
            String deptId = document.getString("deptId");


            // Check if the name and age values from MongoDB are present in the CSV data set
            if (csvDataValues.contains(empName) && csvDataValues.contains(empId) && csvDataValues.contains(empSalary) && csvDataValues.contains(deptId)) {
                LogImplementation.info("Data matches for: " + empName + ", " + empId + ", " + empSalary + ", " + deptId);
                check = true;
            } else {
                LogImplementation.info("Data doesn't match for: " + empName + ", " + empId + ", " + empSalary + ", " + deptId);
                check = false;
            }
        }
        return check;
    }
}

