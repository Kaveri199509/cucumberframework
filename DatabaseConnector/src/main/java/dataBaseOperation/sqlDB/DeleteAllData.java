package dataBaseOperation.sqlDB;

import dataBaseOperation.exception.GlobalException;
import org.example.DbConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllData {

        public static void deleteData(String tableName,String columnName, String valueToDelete) {
            String deleteQuery = "DELETE FROM " + tableName + " WHERE "  +columnName+"= ?";
            try  (
                    PreparedStatement preparedStatement = DbConnector.setCon().prepareStatement(deleteQuery)){
                    preparedStatement.setString(1, valueToDelete);
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Data deleted successfully.");
                    } else {
                        System.out.println("No data found for deletion.");
                    }

            }  catch (ClassNotFoundException|SQLException e) {
                throw new GlobalException("Error");
            }
        }
    }
