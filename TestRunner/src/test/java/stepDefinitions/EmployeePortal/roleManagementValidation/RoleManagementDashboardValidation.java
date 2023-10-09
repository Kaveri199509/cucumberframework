package stepDefinitions.EmployeePortal.roleManagementValidation;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageFactory.employeePortal.roleManagement.RoleManagementDashboard;
import stepDefinitions.BrowserHelper;

import java.util.List;
import java.util.Map;

public class RoleManagementDashboardValidation {
RoleManagementDashboard totalRoleApi;
   @Then("the user should see the total Roles on role Management dashboard")
    public void the_user_should_see_the_total_roles_on_role_Management_dashboard() {
       totalRoleApi = new RoleManagementDashboard(BrowserHelper.getDriverName());
       List<Map<String, Object>> totalRole = totalRoleApi.getTotalRoleApi();
     int size= totalRoleApi.getTotalRole();
       Assert.assertEquals(totalRole.size(),size);

    }

    @Then("edit role button should be disable")
    public void edit_role_button_should_be_disable() {
       totalRoleApi = new RoleManagementDashboard(BrowserHelper.getDriverName());
        boolean status=totalRoleApi.editRole();
        Assert.assertEquals(status,false);


    }
}
