package stepDefinitions.EmployeePortal.roleManagementValidation;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageFactory.employeePortal.roleManagement.AddNewRole;
import stepDefinitions.BrowserHelper;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddNewRoleValidation {

   AddNewRole addNewRole;
    boolean status=true;
    private String roleName;
  private boolean  checked;
    private Map<String, String> rolePermissions = new HashMap<>();
    @When("user enter role name {string}")
    public void user_enter_role_name(String roleName) throws InterruptedException {
        addNewRole=new AddNewRole(BrowserHelper.getDriverName());
        addNewRole.getName(roleName);
    }
    @When("user sets the following module permissions:")
    public void user_sets_the_following_module_permissions(DataTable table) throws InterruptedException {
        addNewRole = new AddNewRole(BrowserHelper.getDriverName());
        addNewRole.getNewRole(table);
    }
    @When("user click on Submit Form Button")
    public void user_click_on_submit_form_button() {
        addNewRole=new AddNewRole(BrowserHelper.getDriverName());
        addNewRole.submit();
        addNewRole.refresh();
    }

    @When("user search the role name {string}")
    public void user_search_the_role_name(String roleName) {
        addNewRole=new AddNewRole(BrowserHelper.getDriverName());
        addNewRole.searchRole(roleName);
    }
    @When("user select the role Manager")
    public void user_select_the_role_manager(){
        addNewRole=new AddNewRole(BrowserHelper.getDriverName());
        addNewRole.selectRole();

    }
    @Then("manager have the following permissions:")
    public void manager_have_the_following_permissions(DataTable permission) throws IOException {
        addNewRole=new AddNewRole(BrowserHelper.getDriverName());
        addNewRole.validatePermission(permission);
    }

    @When("user doesn't provide any module permissions:")
    public void user_doesn_t_provide_any_module_permissions() {
        addNewRole=new AddNewRole(BrowserHelper.getDriverName());
        status= checked=addNewRole.ValidateCheckedBox();

    }

    @Then("Submit Form Button should be disabled")
    public void submit_form_button_should_be_disabled() {
        addNewRole=new AddNewRole(BrowserHelper.getDriverName());
        status= addNewRole.ValidateCheckedBox();
        boolean buttonsStatus= addNewRole.buttonStatus();
        Assert.assertEquals(status,buttonsStatus);

    }








    public static void assertPermissions(List<Map<String, String>> expectedPermissions, List<Map<String, String>> actualPermissions) {

  //      Assert.assertEquals( expectedPermissions.size(), actualPermissions.size());

        for (int i = 0; i < expectedPermissions.size(); i++) {
            Map<String, String> expectedPermission = expectedPermissions.get(i);
            Map<String, String> actualPermission = actualPermissions.get(i);

            String expectedModuleName = expectedPermission.get("Module");
            String actualModuleName = actualPermission.get("moduleName");

            Assert.assertEquals("Module names do not match for permission " + (i + 1), expectedModuleName, actualModuleName);

            String expectedPermissionString = expectedPermission.get("Permissions");
            String[] expectedPermissionList = expectedPermissionString.split(",\\s*");

            String actualPermissionString = actualPermission.get("modulePermissions");
            String[] actualPermissionList = actualPermissionString.split(",");

            Assert.assertEquals( expectedModuleName, expectedPermissionList, Arrays.toString(actualPermissionList));
        }}}
