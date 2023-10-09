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

public class SelectDataWhereClause {

    private SelectDataWhereClause() {

    }

    public static List<Map<String, Object>> selectDataFromTable(String tableName, String whereClause) {
        List<Map<String, Object>> rows = new ArrayList<>();

        try {
            String selectQuery = createSelectQuery(tableName, whereClause);
            try (Statement statement = DbConnector.setCon().createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {

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

            return rows;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DataBaseQueryException("Error selecting data from table: " + e.getMessage(), e);
        }
    }

    private static String createSelectQuery(String tableName, String whereClause) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT * FROM ").append(tableName);
        if (whereClause != null && !whereClause.isEmpty()) {
            queryBuilder.append(" WHERE ").append(whereClause);
        }
        return queryBuilder.toString();
    }
}
