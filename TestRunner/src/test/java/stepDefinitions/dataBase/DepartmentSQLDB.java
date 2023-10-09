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

import java.util.List;
import java.util.Map;

public class DepartmentSQLDB {
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


    @Given("I have the data from department.csv file")
    public void i_have_the_data_from_department_csv_file() {
        String delimiter = ",";
        csvData = csvFileReader.readCSVData(configFileReader.getCsvFilePath(), delimiter);
    }

    @When("I insert the data Into the department table")
    public void i_insert_the_data_into_the_department_table() {
        initialRowCount = CountRowsInTable.countRowsInTable(configFileReader.getTableName());
        count = InsertData.insertDataIntoTable(csvData, configFileReader.getTableName());
    }

    @Then("I verify Data should be inserted into the table")
    public void i_verify_data_should_be_inserted_into_the_table() {
         int csvFileSize = csvData.size();
        int size = initialRowCount - csvFileSize;
        int actualValue = Math.abs(size);
        Assert.assertEquals(csvFileSize, actualValue);
        LogImplementation.info("Assertion passed!");
    }

    @When("I retrieve data from the department table")
    public void i_retrieve_data_from_the_department_table() {
        retrievedData = SelectData.selectDataFromTable(configFileReader.getTableName());
        LogImplementation.info("data retrieve from the table");
    }

    @Then("data should match with department.csv file")
    public void data_should_match_with_department_csv_file() {
        List<String> sqlData = MongoDBSelectDataFromCSV.compareSQlAndCSV(retrievedData);
        List<String> csvData = MongoDBSelectDataFromCSV.readColumnData(configFileReader.getCsvFilePath(), 0);
        boolean csvData1 = MongoDBSelectDataFromCSV.CompareDataToCSV(csvData,sqlData);
        LogImplementation.info("csvData1 = " + csvData1);
        Assert.assertTrue(csvData1);
    }

    @Given("I want to update data in the table department where {string} is {int}")
    public void i_want_to_update_data_in_the_table_department_where_is(String columnName, int columnValue) {
        this.columnName = columnName;
        this.columnValue = columnValue;

    }

    @When("I update the Data with the following value")
    public void i_update_the_data_with_the_following_value(io.cucumber.datatable.DataTable dataTable) {
        columns = dataTable.asMaps(String.class, Object.class);
        updateCount= UpdateDataByColumn.updateDataInTable(columns, configFileReader.getTableName(), columnName, columnValue);
    }

    @Then("data should be updated")
    public void data_should_be_updated() {
        retrievedData = SelectDataWithColumnValue.selectDataFromTable(configFileReader.getTableName(), columnName, columnValue);
        int retrievedCount= retrievedData.size();
        Assert.assertEquals(updateCount,retrievedCount);
        LogImplementation.info("Assertion passed!");
    }

    @When("I delete the Data from the table using column")
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

    @Then("data should be deleted successfully")
    public void data_should_be_deleted_successfully() {
        int actualValue = CountRowsInTableByValue.countRowsByColumnWithCondition(configFileReader.getTableName(), key, value);
        Assert.assertEquals(0, actualValue);
        LogImplementation.info("Assertion passed!");
    }
}
