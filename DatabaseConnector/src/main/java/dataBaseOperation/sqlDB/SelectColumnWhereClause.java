package dataBaseOperation.sqlDB;

import dataBaseOperation.exception.GlobalException;
import org.example.DbConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectColumnWhereClause {
    private SelectColumnWhereClause() {

        }
    public static List<Map<String, String>> selectDataFromTable(String tableName, String columnName, String columnValue,String columnToGet) {
        List<Map<String, String>> rows = new ArrayList<>();

        try {
            String selectQuery = createSelectQuery(tableName, columnName,columnToGet);
            try (Connection connection = DbConnector.setCon();
                 PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setObject(1, columnValue);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    while (resultSet.next()) {
                        Map<String, String> row = new HashMap<>();

                        for (int i = 1; i <= columnCount; i++) {
                            String columnNameFromMetadata = metaData.getColumnName(i);
                            String columnValueFromResultSet = (String) resultSet.getObject(i);
                            row.put(columnNameFromMetadata, columnValueFromResultSet);
                        }
                        rows.add(row);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new GlobalException("Error");
        }
        return rows;
    }


    private static String createSelectQuery(String tableName, String columnName,String ColumnToGet) {
            return "SELECT "+ColumnToGet+ " FROM " + tableName + " WHERE " + columnName + " = ?";
        }

        private static void closeConnection() {
            try {
                if (DbConnector.setCon() != null) {
                    DbConnector.setCon().close();
                }
            } catch (SQLException |ClassNotFoundException e) {
                throw new GlobalException("Error");
            }
        }


}
