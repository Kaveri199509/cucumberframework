package pageFactory.employeePortal.roleManagement;

import io.restassured.response.Response;
import org.example.RestObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.JsonFormatterTotalRoleApi;
import utility.WebDriverUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleManagementDashboard {
    WebDriver driver;
    static String baseUrl = "http://localhost:5000/";
    static Map<String, String> headerValues = new HashMap<>();
    @FindBy(xpath = "//div[@class='mt-4']")
    private WebElement totalRole;

    @FindBy(xpath = "//button[contains(text(),'Edit Role')]")
    private WebElement editRoleButton;

    public RoleManagementDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<Map<String, Object>> getTotalRoleApi() {
        String pathUrl = "rbac/get-all-roles";
        Response response = RestObjects.getData(baseUrl, pathUrl, getHeaderValue());
        String[] authorization = response.getHeader("authorization").split(" ");
        System.out.println("Role authorization = " + authorization[1]);
       return JsonFormatterTotalRoleApi.getJwtData(authorization[1]);


    }

    private Map<String, String> getHeaderValue() {
        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbXBJZCI6MiwiaWF0IjoxNjk1MzY4MzM1fQ.OxPCOjagn6G05vp2Wqw3DpNapkL_UYpzQxU4ULf6ypQ";
        headerValues.put("Authorization", "Bearer " + bearerToken);
        return headerValues;
    }

    public int getTotalRole() {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,totalRole);
        String[] roleText = totalRole.getText().split(" ");
        String totalRoles = roleText[3];
        return Integer.parseInt(totalRoles);

    }

    public boolean editRole() {
      return   editRoleButton.isEnabled();

    }
}