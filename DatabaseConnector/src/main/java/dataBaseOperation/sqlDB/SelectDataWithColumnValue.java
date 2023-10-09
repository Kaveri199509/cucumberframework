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

public class SelectDataWithColumnValue {

    private SelectDataWithColumnValue() {

    }

    public static List<Map<String, Object>> selectDataFromTable(String tableName, String columnName, Object columnValue) {
        List<Map<String, Object>> rows = new ArrayList<>();

        try (PreparedStatement preparedStatement = createPreparedStatement(tableName, columnName, columnValue);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();

                for (int i = 1; i <= columnCount; i++) {
                    String columnNameFromMetadata = metaData.getColumnName(i);
                    Object columnValueFromResultSet = resultSet.getObject(i);
                    row.put(columnNameFromMetadata, columnValueFromResultSet);
                }

                rows.add(row);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new DataBaseQueryException("Error selecting data from table: " + e.getMessage(), e);
        }

        return rows;
    }

    private static PreparedStatement createPreparedStatement(String tableName, String columnName, Object columnValue)
            throws SQLException, ClassNotFoundException {

        try (PreparedStatement preparedStatement = DbConnector.setCon().prepareStatement(generateQuery(tableName,columnName))) {
            preparedStatement.setObject(1, columnValue);
            return preparedStatement;
        }
    }

    private static String generateQuery(String tableName, String columnName) {
        return "SELECT * FROM " + tableName + " WHERE " + columnName + " = ?";
    }
}