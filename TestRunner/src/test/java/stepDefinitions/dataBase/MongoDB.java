package stepDefinitions.dataBase;

import configFileReader.ConfigFileReader;
import constants.LogImplementation;
import dataBaseOperation.mongodb.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MongoDB {

    static long collectionSize;
    static boolean allCollection = false;
    static long intialCount;
    static long finalCount;
    static long modifiedData;
    static List<Map<String, Object>> data;
    long deletedCount = 0;
    ConfigFileReader configFileReader= new ConfigFileReader();

    @When("I want to insert data from employee.csv file")
    public void i_want_to_insert_data_from_employee_csv_file() throws IOException {
        intialCount = MongoDBDocumentCount.getDocumentCount();
        LogImplementation.info("configFileReader = " + configFileReader.getCsvFilePath());
        collectionSize = MongoDBInsertData.insertCSVFile(configFileReader.getCsvFilePath());
        finalCount = MongoDBDocumentCount.getDocumentCount();
    }

    @Then("I verify all the data inserted in backend")
    public void i_verify_all_the_data_inserted_in_backend() {
        Assert.assertEquals(intialCount, finalCount - collectionSize);
    }

    @When("I want to read all the documents from employee.csv file")
    public void i_want_to_read_all_the_documents_from_employee_csv_file() {
        allCollection = MongoDBSelectData.getAllCollection();
    }

    @Then("I verify all the data selected from backend")
    public void i_verify_all_the_data_selected_from_backend() {
        List<String> mongoData = MongoDBSelectDataFromCSV.compareMongoAndCSV();
        List<String> csvData = MongoDBSelectDataFromCSV.readColumnData(configFileReader.getCsvFilePath(), 0);
        boolean csvData1 = MongoDBSelectDataFromCSV.CompareDataToCSV(csvData,mongoData);
        LogImplementation.info("csvData1 = " + csvData1);
        Assert.assertTrue(csvData1);
    }

    @When("I want to update the empSalary for empId {string}")
    public void i_want_to_update_the_emp_salary_for_emp_id(String empIdToUpdate, io.cucumber.datatable.DataTable dataTable) {
        data = dataTable.asMaps(String.class, Object.class);
        modifiedData = MongoDBUpdateData.updateData(empIdToUpdate, data);

    }

    @Then("I want to verify the data updated")
    public void i_want_to_verify_the_data_updated() {
        LogImplementation.info("data = " + data.size());
        Assert.assertEquals(modifiedData, data.size());
    }


    @When("I want to delete the documents")
    public void i_want_to_delete_the_documents_where_dept_id(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, Object>> dataToDelete = dataTable.asMaps(String.class, Object.class);
        intialCount = MongoDBDocumentCount.getDocumentCount();
        for (Map<String, Object> datas : dataToDelete) {
            for (Map.Entry<String, Object> entry : datas.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                LogImplementation.info("Key: " + key + ", Value: " + value);
                deletedCount =  deletedCount + MongoDBDeleteData.deleteData(key, value);
            }
        }
    }

    @Then("I want to verfiy if the delete is deleted from backend")
    public void i_want_to_verfiy_if_the_delete_is_deleted_from_backend() {
        LogImplementation.info("deletedCount = " + deletedCount);
        finalCount = MongoDBDocumentCount.getDocumentCount();
        Assert.assertEquals(finalCount,intialCount-deletedCount);
    }

}
