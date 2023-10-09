package stepDefinitions.EmployeePortal.roleManagementValidation;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageFactory.employeePortal.roleManagement.SearchRoleApi;
import stepDefinitions.BrowserHelper;

import java.util.List;
import java.util.Map;


public class SearchRoleApiValidation {
    SearchRoleApi searchRoleApi;

    @Then("super admin have the given permissions:")
    public void super_admin_have_the_given_permissions() {
        searchRoleApi = new SearchRoleApi(BrowserHelper.getDriverName());
        Map<String, List<String>> moduleAndPermission = searchRoleApi.getModuleAndPermission();
        searchRoleApi.print(moduleAndPermission);
        List<Map<String, Object>> roleApi = searchRoleApi.getRoleApi();
        Map<String, List<String>> stringListMap = searchRoleApi.convertToMap(roleApi);
        searchRoleApi.print(stringListMap);
        boolean b = searchRoleApi.verifyData();
        Assert.assertTrue(b);


    }
}
