package stepDefinitions.EmployeePortal.roleManagementValidation;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageFactory.employeePortal.roleManagement.AddRoleTable;
import stepDefinitions.BrowserHelper;

public class AddRoleTableValidation  {
    AddRoleTable addRoleTable;

    @When("the user Clicked on the Role Management Component")
    public void the_user_clicked_on_the_role_management_component() throws InterruptedException {
        addRoleTable=new AddRoleTable(BrowserHelper.getDriverName());
       addRoleTable.roleManagementClick();


    }

    @When("the user Clicked on the  add Role button")
    public void the_user_clicked_on_the_add_role_button() {
        addRoleTable=new AddRoleTable(BrowserHelper.getDriverName());
        addRoleTable.addRoleButton();


    }

    @Then("Module name header should be present")
    public void module_name_header_should_be_present(DataTable header) {
       addRoleTable=new AddRoleTable(BrowserHelper.getDriverName());
      boolean allHeader =addRoleTable.getAllHeader(header.asList());
        Assert.assertTrue(allHeader);
    }

    @Then("modules name should be present")
    public void modules_name_should_be_present(DataTable module) {
        addRoleTable=new AddRoleTable(BrowserHelper.getDriverName());
        addRoleTable.getAllModule(module.asList());
        boolean allModule =addRoleTable.getAllModule(module.asList());
        Assert.assertTrue(allModule);


    }

    @Then("the total number of the checkbox should be  {int}")
    public void the_total_number_of_the_checkbox_should_be(int expectedCheckBox) {
        addRoleTable=new AddRoleTable(BrowserHelper.getDriverName());
       int actualCheckBox= addRoleTable.getAllCheckbox();
       Assert.assertEquals(actualCheckBox,expectedCheckBox);

    }



}
