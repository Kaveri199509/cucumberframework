package dataBaseOperation.sqlDB;

import dataBaseOperation.exception.DataBaseQueryException;
import org.example.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountRowsInTableByValue {

    private CountRowsInTableByValue() {

    }

    public static int countRowsByColumnWithCondition(String tableName, String columnName, Object columnValue) {
        int rowCount = 0;
        try (Connection connection = DbConnector.setCon()) {

            try (PreparedStatement statement = connection.prepareStatement(generateQuery(tableName,columnName))) {
                statement.setObject(1, columnValue);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        rowCount = resultSet.getInt("rowcount");
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DataBaseQueryException("Error counting rows in table: " + e.getMessage(), e);
        }
        return rowCount;
    }

    private static String generateQuery(String tableName, String columnName) {
        return "SELECT COUNT(*) AS rowcount FROM " + tableName + " WHERE " + columnName + " = ?";
    }

}
