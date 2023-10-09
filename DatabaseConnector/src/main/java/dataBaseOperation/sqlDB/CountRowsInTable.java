package dataBaseOperation.sqlDB;

import dataBaseOperation.exception.DataBaseQueryException;
import org.example.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountRowsInTable {

    private CountRowsInTable() {
    }

    public static int countRowsInTable(String tableName) {
        int rowCount = 0;
        try (Connection connection = DbConnector.setCon();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(generateSelectQuery(tableName))) {
            if (resultSet.next()) {
                rowCount = resultSet.getInt("rowcount");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DataBaseQueryException("Error counting rows in table: " + e.getMessage(), e);
        }

        return rowCount;
    }

    private static String generateSelectQuery(String tableName) {
        return "SELECT COUNT(*) AS rowcount FROM ".concat(tableName);
    }
}
