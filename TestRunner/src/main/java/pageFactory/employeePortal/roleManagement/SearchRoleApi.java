package pageFactory.employeePortal.roleManagement;

import io.restassured.response.Response;
import org.example.RestObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.JsonFormatterSearchApi;

import java.util.*;


public class SearchRoleApi {

    @FindBy(xpath = "//th")
    private static WebElement moduleNames;
    WebDriver driver;
    static String baseUrl = "http://localhost:5000/";
    static Map<String, String> headerValues = new HashMap<>();

    @FindBy(xpath = "(//table)[2]/tbody")
    private static WebElement tbody;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[3]/label/input")
    private WebElement checkBox;

    public SearchRoleApi(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Map<String, List<String>> getModuleAndPermission() {
        String[] permissionList = {"view", "add", "update", "download", "upload"};
        Map<String, List<String>> uiDataList = new HashMap<>();
        Collection<String> moduleName = getModuleName();
        for (String str : moduleName) {
            List<String> list = new ArrayList<>();
            WebElement moduleRow = moduleNames.findElement(By.xpath("(//th[text()='" + str + "'])[2]/parent::tr"));
            for (String permissionsList : permissionList) {
                String permission = permissionsList.toLowerCase();
                WebElement checkbox = moduleRow.findElement(By.xpath(".//td[label[input[@value='" + permission + "']]]/label/input"));
                if (checkbox.isSelected()) {
                    list.add(permissionsList);
                }
            }
            uiDataList.put(str, list);
        }
        return uiDataList;
    }

    public void print(Map<String, List<String>> moduleAndPermission) {

        for (Map.Entry<String, List<String>> entry : moduleAndPermission.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();

            System.out.println("Key: " + key);
            System.out.println("Values: " + values);
        }
    }

    //modulesName getModulesName

    public List<String> getModuleName() {
        List<String> moduleList = new ArrayList<>();
        Collection<WebElement> elements = tbody.findElements(By.tagName("th"));
        for (WebElement el : elements) {
            moduleList.add(el.getText());
        }
        for (String str : moduleList) {
            System.out.println("str = " + str);
        }
        return moduleList;
    }

    public List<Map<String, Object>> getRoleApi() {
        String pathUrl = "rbac/get-role-and-permission/7";
        Response response = RestObjects.getData(baseUrl, pathUrl, getHeaderValue());
        String[] authorization = response.getHeader("authorization").toString().split(" ");
        System.out.println("Role authorization = " + authorization[1]);
        List<Map<String, Object>> jwtData = JsonFormatterSearchApi.getJwtData(authorization[1]);
        return jwtData;

    }

    private Map<String, String> getHeaderValue() {
        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbXBJZCI6MiwiaWF0IjoxNjk1MjcxNDYyfQ.2y3Ehd9QAwQx1DhB2lenfCobPX5_g3Mqxg1rnmVG46w";
        headerValues.put("Authorization", "Bearer " + bearerToken);
        return headerValues;
    }

    public boolean verifyData() {
        Map<String, List<String>> moduleAndPermission = getModuleAndPermission();
        List<Map<String, Object>> roleApi = getRoleApi();
        Map<String, List<String>> stringListMap = convertToMap(roleApi);
        // Check if the maps are equal
        boolean areEqual = areMapsEqual(moduleAndPermission, stringListMap);

        if (areEqual) {
            System.out.println("The maps are equal.");
        } else {
            System.out.println("The maps are not equal.");
        }
        return areEqual;
    }

    public static boolean areMapsEqual(Map<String, List<String>> map1, Map<String, List<String>> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }

        for (Map.Entry<String, List<String>> entry : map1.entrySet()) {
            String key = entry.getKey();
            List<String> list1 = entry.getValue();
            Collections.sort(list1);
            List<String> list2 = map2.get(key);
            Collections.sort(list2);
            if (!list1.equals(list2)) {
                System.out.println("list2 = " + list2);
                System.out.println("list1 = " + list1);
                return false;
            }
        }

        return true;
    }

    public  Map<String, List<String>> convertToMap(List<Map<String, Object>> attendanceData) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (Map<String, Object> data : attendanceData) {
            String moduleName = (String) data.get("moduleName");
            List<String> modulePermissions = (List<String>) data.get("modulePermissions");
            resultMap.put(moduleName, modulePermissions);
        }

        for (Map.Entry<String, List<String>> entry : resultMap.entrySet()) {
            System.out.println("data: " + entry);
        }
        return resultMap;
    }
}



