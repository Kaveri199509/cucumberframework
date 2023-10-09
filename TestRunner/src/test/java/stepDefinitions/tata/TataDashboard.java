package stepDefinitions.tata;

import constants.LogImplementation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageFactory.tata.TataDashboardPfm;
import stepDefinitions.BrowserHelper;
import utility.WebDriverUtils;

public class TataDashboard {

    public WebDriver driver;
    TataDashboardPfm tataDashboardPfm;
    public static String total;
    public static String totalSnmp;

    public static String div4Total;

    public TataDashboardPfm getTataDashboardPfm(){
        driver = WebDriverUtils.getDriver();
        BrowserHelper<TataDashboardPfm> tataDashboardPfmBrowserHelper=new BrowserHelper<>(new TataDashboardPfm(driver));
        return tataDashboardPfmBrowserHelper.revDauPage;
    }


    @When("I get the total number of devices from dashboard")
    public void i_get_the_total_number_of_devices_from_dashboard() {
        tataDashboardPfm = new TataDashboardPfm(BrowserHelper.getDriverName());
        total = tataDashboardPfm.getTotalDevice();

    }

    @Then("Total number of devices should be {string}")
    public void total_number_of_devices_should_be(String totalDevice) {
        LogImplementation.info("total = " + total);
        LogImplementation.info("totalDevice = " + totalDevice);
        Assert.assertEquals(total,totalDevice);
    }

    @When("I get the total number of devices SNMP from dashboard")
    public void i_get_the_total_number_of_devices_snmp_from_dashboard() {
        tataDashboardPfm = new TataDashboardPfm(BrowserHelper.getDriverName());
        total =  tataDashboardPfm.getTotalSnmpDevice();
    }

    @When("I get the total number of flow devices from dashboard")
    public void i_get_the_total_number_of_flow_devices_from_dashboard() {
        tataDashboardPfm = new TataDashboardPfm(BrowserHelper.getDriverName());
        total = tataDashboardPfm.getTotalFlowDevice();
    }

    @When("I get the total number of Netflow")
    public void i_get_the_total_number_of_netflow() {
        tataDashboardPfm = new TataDashboardPfm(BrowserHelper.getDriverName());
        total = tataDashboardPfm.getTotalNetFLowDevice();
    }

    @When("I get the SNMP")
    public void i_get_the_snmp() {
        tataDashboardPfm = new TataDashboardPfm(BrowserHelper.getDriverName());
        totalSnmp = tataDashboardPfm.getSnmpDevice();
    }

    @Then("Total number of SNMP should be {string}.")
    public void total_number_of_snmp_should_be(String snmpDevice) {
        LogImplementation.info("totalSnmp = " + totalSnmp);
        LogImplementation.info("snmpDevice = " + snmpDevice);
        Assert.assertEquals(totalSnmp,snmpDevice);
    }

    @When("I get the Total")
    public void i_get_the_total() {
        tataDashboardPfm = new TataDashboardPfm(BrowserHelper.getDriverName());
        div4Total = tataDashboardPfm.getDiv4Total();

    }

    @Then("Total number should be {string}")
    public void total_number_should_be(String div4TotalDevice) {
        LogImplementation.info("div4Total = " + div4Total);
        LogImplementation.info("div4TotalDevice = " + div4TotalDevice);
        Assert.assertEquals(div4Total,div4TotalDevice);
    }

}