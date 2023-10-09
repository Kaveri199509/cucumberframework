package dataBaseOperation.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import constants.LogImplementation;
import dataBaseOperation.exception.DataBaseQueryException;
import org.bson.Document;
import org.example.MongoDbConnection;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MongoDBSelectDataFromCSV {

    private MongoDBSelectDataFromCSV() {

    }

    public static boolean CompareDataToCSV(List<String> columnData, List<String> mongoData) {
        boolean isEqual = true;
        for (String col : columnData) {
            if (!mongoData.contains(col)) {
                isEqual = false;
                break;
            }
        }
        LogImplementation.info("isEqual = " + isEqual);
        return isEqual;
    }

    public static List<String> readColumnData(String filePath, int columnIndex) {
        List<String> columnData = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                if (columnIndex >= 0 && columnIndex < line.length) {
                    columnData.add(line[columnIndex]);
                }
            }
        } catch (IOException e) {
           LogImplementation.info(e.getMessage());
        } catch (CsvValidationException e) {
            throw new DataBaseQueryException(e.getMessage());
        }

        columnData.remove(0);
        LogImplementation.info("columnData = " + columnData);
        return columnData;
    }

    public static List<String> compareMongoAndCSV() {
        MongoCollection<Document> collection = MongoDbConnection.setConnection();
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.iterator();
        List<String> mongoList = new ArrayList<>();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            mongoList.add((String) document.get("empId"));
//       mongoList.add((String) document.get("deptId"));
        }
        LogImplementation.info("mongoList = " + mongoList);
        return mongoList;
    }

    public static List<String> compareSQlAndCSV(List<Map<String, Object>> retrievedData) {
        List<String> sqlData = new ArrayList<>();
        for (Map<String, Object> map : retrievedData) {
            for (Map.Entry<String, Object> mapData : map.entrySet()) {
//                if(mapData.getKey().equals("deptId"))
                if (mapData.getKey().equals("empId")) {
                    sqlData.add(mapData.getValue().toString());
                }
            }
        }
        LogImplementation.info("sqlData = " + sqlData);
        return sqlData;
    }
}


