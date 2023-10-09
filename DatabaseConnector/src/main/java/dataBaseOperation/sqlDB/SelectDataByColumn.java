package dataBaseOperation.sqlDB;

import dataBaseOperation.exception.DataBaseQueryException;
import org.example.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectDataByColumn {

    private SelectDataByColumn() {

    }

    public static List<Map<String, Object>> selectColumnsData(String tableName, List<String> columnNames) {
        List<Map<String, Object>> columnsData = new ArrayList<>();

        try {
            String selectQuery = createSelectQuery(tableName, columnNames);
            try (PreparedStatement statement = DbConnector.setCon().prepareStatement(selectQuery);
                 ResultSet resultSet = statement.executeQuery()) {

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (resultSet.next()) {
                    Map<String, Object> row = new HashMap<>();

                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        if (columnNames.contains(columnName)) {
                            Object columnValue = resultSet.getObject(i);
                            row.put(columnName, columnValue);
                        }
                    }

                    columnsData.add(row);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DataBaseQueryException("Error selecting columns data: " + e.getMessage(), e);
        }

        return columnsData;
    }

    private static String createSelectQuery(String tableName, List<String> columnNames) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT ");

        if (columnNames.isEmpty()) {
            queryBuilder.append("*");
        } else {
            for (int i = 0; i < columnNames.size(); i++) {
                queryBuilder.append(columnNames.get(i));
                if (i != columnNames.size() - 1) {
                    queryBuilder.append(", ");
                }
            }
        }

        queryBuilder.append(" FROM ").append(tableName);
        return queryBuilder.toString();
    }
}
