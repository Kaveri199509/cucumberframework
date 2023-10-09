package stepDefinitions.dataBase;

import configFileReader.CSVFileReader;
import configFileReader.ConfigFileReader;
import constants.LogImplementation;
import dataBaseOperation.mongodb.MongoDBSelectDataFromCSV;
import dataBaseOperation.sqlDB.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SqlDB {

    CSVFileReader csvFileReader = new CSVFileReader();
    static ConfigFileReader configFileReader = new ConfigFileReader();
    public List<Map<String, Object>> csvData;
    public List<Map<String, Object>> retrievedData;
    int[] count;
    int updateCount;
    int initialRowCount;
    private String columnName;
    private Object columnValue;
    String key = null;
    Object value = null;
    List<Map<String, Object>> columns;

    @Given("I have the data from employee.csv file")
    public void i_have_the_data_from_employee_csv_file() {
        String delimiter = ",";
        csvData = csvFileReader.readCSVData(configFileReader.getCsvFilePath(), delimiter);

    }

    @When("I insert the data Into the employee table")
    public void i_insert_the_data_into_the_employee_table() {
        initialRowCount = CountRowsInTable.countRowsInTable(configFileReader.getTableName());
        count = InsertData.insertDataIntoTable(csvData, configFileReader.getTableName());
    }

    @Then("I verify data should be inserted into the table")
    public void i_verify_data_should_be_inserted_into_the_table() {
        int csvFileSize = csvData.size();
        int size = initialRowCount - csvFileSize;
        int actualValue = Math.abs(size);
        Assert.assertEquals(csvFileSize, actualValue);
        LogImplementation.info("Assertion passed!");
    }

    @When("I retrieve data from the employee table")
    public void i_retrieve_data_from_the_employee_table() throws SQLException, IOException, ClassNotFoundException {
        retrievedData = SelectData.selectDataFromTable(configFileReader.getTableName());

        LogImplementation.info("data retrieve from the table");
    }

    @Then("data should match with employee.csv file")
    public void data_should_match_with_employee_csv_file() {
//        String delimiter = ",";
//        csvData = csvFileReader.readCSVData(configFileReader.getCsvFilePath(), delimiter);
//        if (retrievedData.size() != csvData.size()) {
//            throw new AssertionError("Lists have different lengths.");
//        }
//
//        for (int i = 0; i < retrievedData.size(); i++) {
//            Map<String, Object> retrievedMap = retrievedData.get(i);
//            Map<String, Object> csvMap = csvData.get(i);
//
//            if (!retrievedMap.keySet().equals(csvMap.keySet())) {
//                throw new AssertionError("Maps have different keys at index " + i);
//            }
//
//            for (String key : retrievedMap.keySet()) {
//                Object retrievedValue = retrievedMap.get(key);
//                Object csvValue = csvMap.get(key);
//                if (key.equals("empSalary")) {
//                    retrievedValue = csvFileReader.convertToDouble(retrievedValue);
//
//                    if (!retrievedValue.equals(csvValue)) {
//                        throw new AssertionError("Maps have different values for key: " + key + " at index " + i);
//                    }
//                } else {
//                    if (!retrievedValue.equals(csvValue)) {
//                        throw new AssertionError("Maps have different values for key: " + key + " at index " + i);
//                    }
//                }
//            }
//        }

        List<String> sqlData = MongoDBSelectDataFromCSV.compareSQlAndCSV(retrievedData);
        List<String> csvData = MongoDBSelectDataFromCSV.readColumnData(configFileReader.getCsvFilePath(), 0);
        boolean csvData1 = MongoDBSelectDataFromCSV.CompareDataToCSV(csvData,sqlData);
        LogImplementation.info("csvData1 = " + csvData1);
        Assert.assertTrue(csvData1);
    }

    @When("I delete the data from the table using column")
    public void i_delete_the_data_from_the_table_using_column(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, Object>> rows = dataTable.asMaps(String.class, Object.class);

        for (Map<String, Object> row : rows) {
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
            }
        }
        CountRowsInTableByValue.countRowsByColumnWithCondition(configFileReader.getTableName(), key, value);
        DeleteData.deleteDataFromTable(rows, configFileReader.getTableName(), key);
    }

    @Then("the data should be deleted successfully")
    public void the_data_should_be_deleted_successfully() {
        int actualValue = CountRowsInTableByValue.countRowsByColumnWithCondition(configFileReader.getTableName(), key, value);
        Assert.assertEquals(0, actualValue);
        LogImplementation.info("Assertion passed!");

    }

    @Given("I want to update data in the table employee where {string} is {int}")
    public void i_want_to_update_data_in_the_table_employee_where_is(String columnName, Integer columnValue) {
        this.columnName = columnName;
        this.columnValue = columnValue;
    }

    @When("I update the data with the following value")
    public void i_update_the_data_with_the_following_value(io.cucumber.datatable.DataTable dataTable) {
        columns = dataTable.asMaps(String.class, Object.class);
     updateCount= UpdateDataByColumn.updateDataInTable(columns, configFileReader.getTableName(), columnName, columnValue);
    }
    @Then("Data should be updated")
    public void data_should_be_updated() {
        retrievedData = SelectDataWithColumnValue.selectDataFromTable(configFileReader.getTableName(), columnName, columnValue);
       int retrievedCount= retrievedData.size();
       Assert.assertEquals(updateCount,retrievedCount);
        LogImplementation.info("Assertion passed!");

    }
}