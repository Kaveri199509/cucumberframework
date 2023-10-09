package pageFactory.employeePortal.employeePolicies;

import dataBaseOperation.exception.GlobalException;
import io.restassured.response.Response;
import org.example.RestObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.JsonFormatterTotalRoleApi;
import utility.TestUtils.ActionClassUtil;
import utility.TestUtils.InputTagUtil;
import utility.TestUtils.JsExecutorUtil;

import java.util.*;

public class Policies {
    WebDriver driver;
   int viewSvg=0;

    static String baseUrl = "http://localhost:5000/";
    static Map<String, String> headerValues = new HashMap<>();
    @FindBy(xpath ="//span[contains(text(),'Policies')]")
    private WebElement policiesModule;
    @FindBy(xpath ="//div[@class='mr-1']")
    private WebElement addPolicyButton;
    @FindBy(xpath ="(//input[@name='policy_name'])[1]")
    private  WebElement policyNameText;

    @FindBy(xpath ="//div[@class='pt-6']//input")
    private WebElement chosePolicyFile;

    @FindBy(xpath ="//form//button[contains(text(),'Add Policy')]")
    private WebElement addPolicyPopupButton;

    @FindBy(xpath ="//tbody[@class='divide-y divide-gray-300']")
    private WebElement addedPolicyNames;

    @FindBy(xpath ="//tbody/tr[1]/td[2]/div/label[2]/button")
    private WebElement editPolicyIcon;

    @FindBy(xpath ="(//input[@name='policy_name'])[2]")
    private WebElement editedPolicyName;

    @FindBy(xpath ="//div[@class='pt-8']//input")
    private WebElement choseEditedPolicyFile;

    @FindBy(xpath ="//form//button[contains(text(),'Edit Policy')]")
    private WebElement saveEditPolicyButton;

    @FindBy(xpath ="//table//tbody")
    private WebElement policiesTable;

    ArrayList<String> oldTab;
    public Policies(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void policiesModule() {
        oldTab =new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(oldTab.get(0));
        ActionClassUtil.actionClassClick(driver,policiesModule);
    }
    public void addPolicyButtons() {
        ActionClassUtil.actionClassClick(driver,addPolicyButton);
    }
    public void getName(String policyName) {
        InputTagUtil.clearData(driver,policyNameText);
       InputTagUtil.setData(driver,policyNameText,policyName);
    }

    public void getFile(String fileName) {
        InputTagUtil.setData(driver,chosePolicyFile,fileName);
    }
    public void policyPopPupButton() {
      ActionClassUtil.actionClassClick(driver,addPolicyPopupButton);
        JsExecutorUtil.refreshBrowser(driver);
    }

    public boolean addedPolicyName(String expectedPolicy) {
     String[] policiesName=addedPolicyNames.getText().split("\n");
        System.out.println("policiesName = " + policiesName);
        System.out.println("expected = " +expectedPolicy);
        List<String> value = Arrays.asList(policiesName);
        return value.contains(expectedPolicy);
    }


    public List<Map<String, Object>> getTotalPoliciesApi() {
       try {
           String pathUrl = "policy/get-all-policies";
           Response response = RestObjects.getData(baseUrl, pathUrl, getHeaderValue());
           String[] authorization = response.getHeader("authorization").split(" ");
           System.out.println("Role authorization = " + authorization[1]);
           return JsonFormatterTotalRoleApi.getJwtData(authorization[1]);
       }catch (RuntimeException ex){
           throw new GlobalException("No value");
       }

    }
    private Map<String, String> getHeaderValue() {
        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbXBJZCI6MiwiaWF0IjoxNjk1NjQzMjg1fQ.g6naOoMtUZSeMLKJ5LwQcuBVBQ0mHQTcgq9_03P6bPU";
        headerValues.put("Authorization", "Bearer " + bearerToken);
        return headerValues;
    }


    public List<String> totalPolicies() {
        String[] policiesName=addedPolicyNames.getText().split("\n");
        return Arrays.asList(policiesName);
    }
    public void getEditFile(String fileName) {
        InputTagUtil.setData(driver,choseEditedPolicyFile,fileName);
    }
    public void getEditedPolicyName(String policyName) {
        InputTagUtil.clearData(driver,editedPolicyName);
        InputTagUtil.setData(driver,editedPolicyName,policyName);
    }
    public void editPolicyIcon() {
        ActionClassUtil.actionClassClick(driver,editPolicyIcon);
    }

    public void editPolicyButton() {
        ActionClassUtil.actionClassClick(driver,saveEditPolicyButton);
    }


    public boolean lookAtEachTableRow() {
        WebElement table =policiesTable;
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            System.out.println("row = " + row);
            List<WebElement> buttonSize =row.findElements(By.tagName("button"));
        int icon= buttonSize.size();
        if ((!(icon ==2))){
            return false;
        }
        }
        return true;
    }



    }
