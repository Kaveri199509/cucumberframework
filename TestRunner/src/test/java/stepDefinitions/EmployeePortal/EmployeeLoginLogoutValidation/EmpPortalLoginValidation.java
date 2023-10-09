package stepDefinitions.EmployeePortal.EmployeeLoginLogoutValidation;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageFactory.employeePortal.employeeLoginLogout.EmployeeLogin;
import stepDefinitions.BrowserHelper;
import utility.ConfigFileReader;

public class EmpPortalLoginValidation {
    EmployeeLogin employeeLoginPFM;
    ConfigFileReader configFileReader;

    String id;
    String password;
    WebDriver driver;

    @When("the user click on Microsoft Login button.")
    public void i_click_on_microsoft_login_button() {
        employeeLoginPFM = new EmployeeLogin(BrowserHelper.getDriverName());
        employeeLoginPFM.msLoginButton();
    }
    @When("user Login for another account")
    public void user_Login_for_another_account(){
        employeeLoginPFM = new EmployeeLogin(BrowserHelper.getDriverName());
        employeeLoginPFM.reLogin();

    }
    @When("the user login as {string}")
    public void the_user_login_as(String role) {
        configFileReader = new ConfigFileReader();
        switch (role) {
            case "Employee":
                id = configFileReader.employeeID();
                password = configFileReader.employeePassword();
                break;
            case "Admin":
                id = configFileReader.adminID();
                password = configFileReader.adminPassword();
                break;
            case "Hr":
                id = configFileReader.hrUserID();
                password = configFileReader.hrUserPassword();
                break;
            case "Rm":
                id = configFileReader.rmUserID();
                password = configFileReader.rmUserPassword();
                break;

        }

        employeeLoginPFM = new EmployeeLogin(BrowserHelper.getDriverName());
        employeeLoginPFM.setUserName(id);
    }

    @When("the user entered password")
    public void the_user_entered_password() {
        employeeLoginPFM = new EmployeeLogin(BrowserHelper.getDriverName());
        employeeLoginPFM.setUserPassword(password);
    }
    @When("the user click next button")
    public void the_user_click_next_button() {
        employeeLoginPFM = new EmployeeLogin(BrowserHelper.getDriverName());
        employeeLoginPFM.clickNextSignIn();
    }


    @When("the user click SignIn button")
    public void the_user_click_sign_in_button() {
        employeeLoginPFM = new EmployeeLogin(BrowserHelper.getDriverName());
        employeeLoginPFM.clickNextSignIn();
    }

    @When("the user Checked in stay sign In checkbox")
    public void the_user_checked_in_stay_sign_in_checkbox(){
        employeeLoginPFM = new EmployeeLogin(BrowserHelper.getDriverName());
        employeeLoginPFM.clickCheckBox();
    }

    @When("the user clicked on no button")
    public void the_user_clicked_on_no_button() {
        employeeLoginPFM = new EmployeeLogin(BrowserHelper.getDriverName());

        employeeLoginPFM.noRemember();
    }

    @Then("Profile name {string} should be displayed on dashboard")
    public void profile_name_should_be_displayed_on_dashboard(String userName){
        employeeLoginPFM = new EmployeeLogin(BrowserHelper.getDriverName());
        String name = employeeLoginPFM.userProfile();
        Assert.assertEquals(name, userName);

    }


}