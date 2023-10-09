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

public class SelectDataWithParameter {

    private SelectDataWithParameter() {

    }

    public static List<Map<String, Object>> selectDataWithParameters(String tableName, Map<String, Object> parameters) {
        List<Map<String, Object>> rows = new ArrayList<>();

        try {
            String selectQuery = createSelectQuery(tableName, parameters);
            try (PreparedStatement statement = DbConnector.setCon().prepareStatement(selectQuery)) {
                int index = 1;
                for (Object value : parameters.values()) {
                    statement.setObject(index++, value);
                }

                try (ResultSet resultSet = statement.executeQuery()) {
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
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DataBaseQueryException("Error selecting data from database: " + e.getMessage(), e);
        }

        return rows;
    }

    private static String createSelectQuery(String tableName, Map<String, Object> parameters) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT * FROM ").append(tableName);

        if (!parameters.isEmpty()) {
            queryBuilder.append(" WHERE ");
            for (String key : parameters.keySet()) {
                queryBuilder.append(key).append(" = ? AND ");
            }
            queryBuilder.delete(queryBuilder.length() - 5, queryBuilder.length()); // Remove the trailing "AND"
        }

        return queryBuilder.toString();
    }
}
