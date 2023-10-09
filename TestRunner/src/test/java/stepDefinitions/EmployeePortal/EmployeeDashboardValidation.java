package stepDefinitions.EmployeePortal;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import stepDefinitions.BrowserHelper;

public class EmployeeDashboardValidation {
    pageFactory.employeePortal.EmployeeDashboard employeeDashboardPFM;
    boolean isClickable;

    @Then("I should see the company logo in the navbar")
    public void i_should_see_the_company_logo_in_the_navbar() {
        employeeDashboardPFM= new pageFactory.employeePortal.EmployeeDashboard(BrowserHelper.getDriverName());
        Assert.assertTrue(employeeDashboardPFM.isLogoDisplayed());
    }
    @Then("I should see the title of the application in the navbar")
    public void i_should_see_the_title_of_the_application_in_the_navbar() {
        employeeDashboardPFM= new pageFactory.employeePortal.EmployeeDashboard(BrowserHelper.getDriverName());
        
    }
    @Then("I should see my profile image in the navbar")
    public void i_should_see_my_profile_image_in_the_navbar() {
        employeeDashboardPFM= new pageFactory.employeePortal.EmployeeDashboard(BrowserHelper.getDriverName());
        Assert.assertTrue(employeeDashboardPFM.isProfileDisplayed());
    }
    @Then("I should see the {string} in the side drawer")
    public void i_should_see_the_in_the_side_drawer(String drawerName) {
        employeeDashboardPFM= new pageFactory.employeePortal.EmployeeDashboard(BrowserHelper.getDriverName());
        String text = employeeDashboardPFM.getText(drawerName);
        Assert.assertEquals(text,drawerName);
        System.out.println("text = " + text);
    }

    @When("I click on the {string}")
    public void i_click_on_the_component(String component) {
        employeeDashboardPFM= new pageFactory.employeePortal.EmployeeDashboard(BrowserHelper.getDriverName());
        isClickable= employeeDashboardPFM.isComponentClickable(component);
        System.out.println("isClickable = " + isClickable);
    }
    @Then("I should check if the component are clickable")
    public void i_should_check_if_the_component_are_clickable() {
        employeeDashboardPFM= new pageFactory.employeePortal.EmployeeDashboard(BrowserHelper.getDriverName());
        Assert.assertTrue(isClickable);
    }

    @Then("I should see an icon for the {string} component")
    public void i_should_see_an_icon_for_the_component(String components) {
        employeeDashboardPFM= new pageFactory.employeePortal.EmployeeDashboard(BrowserHelper.getDriverName());
        boolean iconAvailable = employeeDashboardPFM.isIconAvailable(components);
        Assert.assertTrue(iconAvailable);
    }

    @Then("I should see {string} in the footer")
    public void i_should_see_in_the_footer(String string) {
        employeeDashboardPFM= new pageFactory.employeePortal.EmployeeDashboard(BrowserHelper.getDriverName());
    }
}
