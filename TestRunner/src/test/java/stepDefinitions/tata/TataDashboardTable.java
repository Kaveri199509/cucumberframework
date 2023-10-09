package stepDefinitions.tata;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageFactory.tata.TataDashboardTablePfm;
import stepDefinitions.BrowserHelper;
import utility.WebDriverUtils;

import java.util.List;

public class TataDashboardTable {
    private WebDriver driver;
    TataDashboardTablePfm tataDashboardTablePfm;

    public TataDashboardTablePfm getTataDashboardTablePfm(){
        driver = WebDriverUtils.getDriver();
        BrowserHelper<TataDashboardTablePfm> tataPFMBrowserHelper=new BrowserHelper<>(new TataDashboardTablePfm(driver));
        return tataPFMBrowserHelper.revDauPage;
    }
    @Given("I am on the table number {int}")
    public void i_am_on_the_table_number(int divNumber) {
        tataDashboardTablePfm = new TataDashboardTablePfm(BrowserHelper.getDriverName());
        tataDashboardTablePfm.getDivHeader(divNumber);

    }

    @Then("I should see a table {int}")
    public void i_should_see_a_table(int divRow) {
        tataDashboardTablePfm = new TataDashboardTablePfm(BrowserHelper.getDriverName());
        tataDashboardTablePfm.getDivHeader(divRow);
        Assert.assertTrue(tataDashboardTablePfm.getIsTableVisible());
    }

    @When("I check the table header")
    public void i_check_the_table_header() {
        tataDashboardTablePfm = new TataDashboardTablePfm(BrowserHelper.getDriverName());
    }

    @Then("the table header should contain the following columns {int}:")
    public void the_table_header_should_contain_the_following_columns(int divRow, List<String> expectedColumns) {
        tataDashboardTablePfm = new TataDashboardTablePfm(BrowserHelper.getDriverName());
        tataDashboardTablePfm.getDivHeader(divRow);
        String[] headerName = tataDashboardTablePfm.getHeaderText();
        for (String header: headerName){
            Assert.assertTrue(expectedColumns.contains(header));
        }
    }

    @When("I check the table row data")
    public void i_check_the_table_row_data() {
        tataDashboardTablePfm = new TataDashboardTablePfm(BrowserHelper.getDriverName());

    }

    @Then("at least one row of data should be present in the table {int}")
    public void at_least_one_row_of_data_should_be_present_in_the_table(int divRow) {
        tataDashboardTablePfm = new TataDashboardTablePfm(BrowserHelper.getDriverName());
        tataDashboardTablePfm.getDivHeader(divRow);
        tataDashboardTablePfm.checkAllDataOfTable();
    }

    @When("I check the table section")
    public void i_check_the_table_section() {
        tataDashboardTablePfm = new TataDashboardTablePfm(BrowserHelper.getDriverName());
    }

    @Then("I should see table name with date time {int} {string}")
    public void i_should_see_table_name_with_date_time(int divRow,String expectedFormat) {
        tataDashboardTablePfm = new TataDashboardTablePfm(BrowserHelper.getDriverName());
        tataDashboardTablePfm.getDivHeader(divRow);
        Assert.assertTrue(tataDashboardTablePfm.getDateTimeValidator(expectedFormat));
        tataDashboardTablePfm.getIsTableNameAvailable();
    }

    @When("I get the total number of row")
    public void i_get_the_total_number_of_row() {
        tataDashboardTablePfm = new TataDashboardTablePfm(BrowserHelper.getDriverName());
    }

    @Then("the number of row should {int} be {int}")
    public void the_number_of_row_should_be(int divRow, int rowsize ) {
        tataDashboardTablePfm = new TataDashboardTablePfm(BrowserHelper.getDriverName());
        tataDashboardTablePfm.getDivHeader(divRow);
        Assert.assertEquals(rowsize,tataDashboardTablePfm.getRow());
    }

    @When("i get the total number of column")
    public void i_get_the_total_number_of_column() {
        tataDashboardTablePfm = new TataDashboardTablePfm(BrowserHelper.getDriverName());
    }

    @Then("the number of column should {int} be {int}")
    public void the_number_of_column_should_be(int divRow,int colsize) {
        tataDashboardTablePfm = new TataDashboardTablePfm(BrowserHelper.getDriverName());
        tataDashboardTablePfm.getDivHeader(divRow);
        Assert.assertEquals(colsize,tataDashboardTablePfm.getCol());
    }

}

