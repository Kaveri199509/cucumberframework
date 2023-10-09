package stepDefinitions.EmployeePortal.EmployeeLoginLogoutValidation;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageFactory.employeePortal.employeeLoginLogout.EmployeeLogout;
import stepDefinitions.BrowserHelper;
import utility.ConfigFileReader;

import java.util.ArrayList;

public class EmpPortalLogoutValidation {
    WebDriver driver;
    EmployeeLogout employeeLogoutPFM;
    ConfigFileReader configFileReader;
    ArrayList<String> oldTab;
    boolean isLogOut;


    @When("the user click on Profile the dropdown appears")
    public void the_user_click_on_profile_the_dropdown_appears() throws InterruptedException {
        employeeLogoutPFM = new EmployeeLogout(BrowserHelper.getDriverName());
        employeeLogoutPFM.profile();
        Thread.sleep(3000);
    }

    @When("user click outside the profile")
    public void user_click_outside_the_profile() throws InterruptedException {
        employeeLogoutPFM = new EmployeeLogout(BrowserHelper.getDriverName());
        employeeLogoutPFM.clickDiv();
    }

    @Then("user should see dropdown is closed")
    public void user_should_see_dropdown_is_closed() {
        employeeLogoutPFM = new EmployeeLogout(BrowserHelper.getDriverName());
        boolean dropdownClosed = employeeLogoutPFM.isDropdownClosed();
        System.out.println("dropdownClosed = " + dropdownClosed);
        Assert.assertFalse(dropdownClosed);
    }

    @When("the user click on Profile")
    public void the_user_click_on_profile() throws InterruptedException {
        employeeLogoutPFM = new EmployeeLogout(BrowserHelper.getDriverName());
        employeeLogoutPFM.profile();
    }

    @When("the user clicks the Logout button")
    public void the_user_clicks_the_logout_button() {
        employeeLogoutPFM = new EmployeeLogout(BrowserHelper.getDriverName());
        isLogOut = employeeLogoutPFM.logOut();

    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        Assert.assertTrue(isLogOut);
    }

    @When("the user click on Profile button")
    public void the_user_click_on_profile_button() throws InterruptedException {
        employeeLogoutPFM = new EmployeeLogout(BrowserHelper.getDriverName());
        employeeLogoutPFM.profileClick();

    }

    @Then("the user should see the profile page")
    public void the_user_should_see_the_profile_page() {
        employeeLogoutPFM = new EmployeeLogout(BrowserHelper.getDriverName());
        Assert.assertTrue(employeeLogoutPFM.profileUrl());


    }

}
