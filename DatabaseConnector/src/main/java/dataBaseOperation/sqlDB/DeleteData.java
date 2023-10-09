package dataBaseOperation.sqlDB;

import constants.LogImplementation;
import dataBaseOperation.exception.DataBaseQueryException;
import dataBaseOperation.exception.GlobalException;
import org.example.DbConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DeleteData {

    private static String createDeleteQuery(String tableName, String ColumnName) {
        return "DELETE FROM " + tableName + " WHERE " + ColumnName + " = ?";
    }

    public static void deleteDataFromTable(List<Map<String, Object>> rows, String tableName, String ColumnName) {
        try (

                PreparedStatement preparedStatement = DbConnector.setCon().prepareStatement(createDeleteQuery(tableName, ColumnName))) {
            for (Map<String, Object> row : rows) {
                Object value = row.get(ColumnName);
                preparedStatement.setObject(1, value);
                preparedStatement.addBatch();
            }
            int[] updateCounts = preparedStatement.executeBatch();
            int totalRowsAffected = 0;

            for (int updateCount : updateCounts) {
                if (updateCount != PreparedStatement.EXECUTE_FAILED) {
                    totalRowsAffected += updateCount;
                }
            }

            if (totalRowsAffected > 0) {
                LogImplementation.info("Data deleted successfully! Rows affected: " + totalRowsAffected);
            } else {
                throw new GlobalException("Data not deleted. No matching rows found.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DataBaseQueryException(e.getMessage());
        }
    }


}

