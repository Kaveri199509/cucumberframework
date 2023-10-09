package dataBaseOperation.sqlDB;

import dataBaseOperation.exception.DataBaseQueryException;
import org.example.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UpdateDataByColumn {
    private UpdateDataByColumn() {
    }

    public static int updateDataInTable(List<Map<String, Object>> rows, String tableName, String idColumnName, Object idValue) {
        int affectedRows = 0;
        try (Connection connection = DbConnector.setCon();
             PreparedStatement preparedStatement = connection.prepareStatement(createUpdateQuery(tableName, idColumnName, rows))) {

            for (Map<String, Object> row : rows) {
                int index = 1;
                for (Object value : row.values()) {
                    preparedStatement.setObject(index++, value);
                }
                preparedStatement.setObject(index, idValue);
                affectedRows += preparedStatement.executeUpdate();
            }
            return affectedRows;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DataBaseQueryException("Error updating data in table: " + e.getMessage(), e);
        }
    }

    private static String createUpdateQuery(String tableName, String idColumnName, List<Map<String, Object>> rows) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("UPDATE ").append(tableName).append(" SET ");
        Map<String, Object> stringObjectMap = rows.get(0);
        List<String> columnNames = new ArrayList<>();
        for (String key : stringObjectMap.keySet()) {
            columnNames.add(key);
        }
        for (String columnName : columnNames) {
            queryBuilder.append(columnName).append(" = ?, ");
        }
        queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length()); // Remove the extra comma and space

        queryBuilder.append(" WHERE ").append(idColumnName).append(" = ?");

        return queryBuilder.toString();
    }
}



