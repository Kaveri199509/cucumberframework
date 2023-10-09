package dataBaseOperation.sqlDB;

import dataBaseOperation.exception.GlobalException;
import org.example.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class InsertData {

    private InsertData() {

    }

    public static int[] insertDataIntoTable(List<Map<String, Object>> rows, String tableName) {
        try (Connection connection = DbConnector.setCon()) {
            String insertQuery = generateInsertQuery(rows.get(0), tableName);
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                return executeBatchWithExceptionHandling(preparedStatement, rows, "Error while inserting data into the table: ");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new GlobalException("Error connecting to the database: " + e.getMessage());
        }
    }

    private static int[] executeBatchWithExceptionHandling(PreparedStatement preparedStatement, List<Map<String, Object>> rows, String errorMessagePrefix) throws SQLException {
        for (Map<String, Object> row : rows) {
            int index = 1;
            for (Object value : row.values()) {
                preparedStatement.setObject(index++, value);
            }
            preparedStatement.addBatch();
        }

        try {
            return preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new GlobalException(errorMessagePrefix + e.getMessage());
        }
    }


    private static String generateInsertQuery(Map<String, Object> row, String tableName) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("INSERT INTO ").append(tableName).append(" (");

        for (String columnName : row.keySet()) {
            queryBuilder.append(columnName).append(", ");
        }
        queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
        queryBuilder.append(") VALUES (");
        int columnCount = row.size();
        for (int i = 0; i < columnCount; i++) {
            queryBuilder.append("?, ");
        }
        queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());

        queryBuilder.append(")");

        return queryBuilder.toString();
    }
}
