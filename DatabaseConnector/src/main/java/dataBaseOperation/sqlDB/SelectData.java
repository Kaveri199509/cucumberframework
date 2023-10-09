package dataBaseOperation.sqlDB;

import dataBaseOperation.exception.DataBaseQueryException;
import org.example.DbConnector;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectData {

    private SelectData() {

    }

    public static List<Map<String, Object>> selectDataFromTable(String tableName) {
        List<Map<String, Object>> rows = new ArrayList<>();

        try {
            try (Statement statement = DbConnector.setCon().createStatement();
                 ResultSet resultSet = statement.executeQuery(createSelectQuery(tableName))) {

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (resultSet.next()) {
                    Map<String, Object> row = new HashMap<>();

                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object columnValue = resultSet.getObject(i);
                        row.put(columnName, columnValue);
                    }

                    rows.add(row);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DataBaseQueryException("Error selecting data from table: " + e.getMessage(), e);
        }

        return rows;
    }

    private static String createSelectQuery(String tableName) {
        return "SELECT * FROM " + tableName;
    }
}
