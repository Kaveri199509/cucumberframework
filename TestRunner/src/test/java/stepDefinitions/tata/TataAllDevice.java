package stepDefinitions.tata;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageFactory.tata.TataAllDevicePFM;
import stepDefinitions.BrowserHelper;

import java.util.List;

public class TataAllDevice {

    public WebDriver driver;
    TataAllDevicePFM tataAllDevicePFM;

//    public TataAllDevicePFM getTataAllDevicePFM(){
//        driver = WebDriverUtils.getDriver();
//        BrowserHelper<TataAllDevicePFM> tataAllDevicePFMBrowserHelper=new BrowserHelper<>(new TataAllDevicePFM(driver));
//        return tataAllDevicePFMBrowserHelper.revDauPage;
//    }

    @Given("I click on the total device div")
    public void i_click_on_the_total_device_div() {
        tataAllDevicePFM = new TataAllDevicePFM(BrowserHelper.getDriverName());
        tataAllDevicePFM.clickDiv();
    }
    @Then("I got redirected to the total device dashboard page")
    public void i_got_redirected_to_the_total_device_dashboard_page() {
        tataAllDevicePFM = new TataAllDevicePFM(BrowserHelper.getDriverName());
        tataAllDevicePFM.getOnDashboardPage();
    }
    @When("I selected the {int} from show entries dropdown")
    public void i_selected_the_from_show_entries_dropdown(int dropDownValue) {
        tataAllDevicePFM =  new TataAllDevicePFM(BrowserHelper.getDriverName());
        tataAllDevicePFM.setDropDownValue(dropDownValue);
    }
    @Then("the total number rows should be {int}")
    public void the_total_number_rows_should_be(int tablelength) {
        tataAllDevicePFM = new TataAllDevicePFM(BrowserHelper.getDriverName());
        Assert.assertEquals(tablelength,tataAllDevicePFM.getTableLength());

    }
    @Then("I check the table header name :")
    public void i_check_the_table_header_name(List<String> columnName) throws InterruptedException {
        tataAllDevicePFM = new TataAllDevicePFM(BrowserHelper.getDriverName());
        List<String> headerName = tataAllDevicePFM.getHeaderText();
        for (String header: headerName){
            Assert.assertTrue(columnName.contains(header));
        }
    }
    @Then("I check if the columns of table contains data")
    public void i_check_if_the_columns_of_table_contains_data() {
        tataAllDevicePFM = new TataAllDevicePFM(BrowserHelper.getDriverName());
        tataAllDevicePFM.isDataAvailable();
        Assert.assertTrue(tataAllDevicePFM.isDataAvailable());
    }

    @Given("I am on the search page")
    public void i_am_on_the_search_page() {
        tataAllDevicePFM = new TataAllDevicePFM(BrowserHelper.getDriverName());
    }

    @When("I search for {string}")
    public void i_search_for(String string) throws InterruptedException {
       tataAllDevicePFM = new TataAllDevicePFM(BrowserHelper.getDriverName());
       tataAllDevicePFM.doSearch(string);
    }

    @Then("I should see search results for {string}")
    public void i_should_see_search_results_for(String keyword) throws InterruptedException {
        tataAllDevicePFM = new TataAllDevicePFM(BrowserHelper.getDriverName());
        String s = tataAllDevicePFM.checkText();
        Assert.assertTrue(s.contains(keyword));
    }

    @When("I click on download pdf")
    public void i_click_on_download_pdf() throws InterruptedException {
       tataAllDevicePFM = new TataAllDevicePFM(BrowserHelper.getDriverName());
        tataAllDevicePFM.setDownloadExcel();
    }

    @Then("I can see excel file got downloaded.")
    public void i_can_see_excel_file_got_downloaded() throws InterruptedException {
        tataAllDevicePFM = new TataAllDevicePFM(BrowserHelper.getDriverName());
        boolean b = tataAllDevicePFM.isFileDownloaded();
        Assert.assertTrue(b);
    }

}
