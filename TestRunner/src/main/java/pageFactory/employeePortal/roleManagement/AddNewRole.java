package pageFactory.employeePortal.roleManagement;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtils.ActionClassUtil;
import utility.TestUtils.InputTagUtil;
import utility.TestUtils.JsExecutorUtil;

import java.util.List;
import java.util.Map;

public class AddNewRole {
    WebDriver driver;
    //   boolean buttonStatus;

    @FindBy(xpath = "//button[contains(text(),'Add Role')]")
    private WebElement addRoleButton;
    @FindBy(xpath = "//th")
    private WebElement moduleNames;

    @FindBy(xpath = "//input[@name='role_name']")
    private WebElement roleNameTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitForm;
    @FindBy(xpath = "//input[@placeholder='Search or Select']")
    private WebElement searchRole;

    @FindBy(xpath = "//ul[@class=' top-full left-0 w-full z-auto border border-gray-300 bg-white rounded mt-1']//li[1]")
    private WebElement selectRole;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkBoxSize;

    int initialCount = 0;
    int finalCount = 0;

    public AddNewRole(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getNewRole(DataTable table) {

        List<Map<String, String>> modulePermissions = table.asMaps();
        for (Map<String, String> row : modulePermissions) {
            String moduleName = row.get("Module");
            String permissions = row.get("Permissions");
            WebElement moduleRow = moduleNames.findElement(By.xpath("//th[text()='" + moduleName + "']/parent::tr"));
            String[] permissionList = permissions.split(",\\s*");
            for (String permissionsList : permissionList) {
                String permission = permissionsList.toLowerCase();
                WebElement checkbox = moduleRow.findElement(By.xpath(".//td[label[input[@value='" + permission + "']]]/label/input"));
                checkbox.click();
            }
        }

    }

    public void getName(String name) {

        InputTagUtil.setData(driver, roleNameTextBox, name);


    }

    public void submit() {
        JsExecutorUtil.scrollDown(driver,submitForm);
        ActionClassUtil.actionClassClick(driver, submitForm);

    }


    public void searchRole(String name) {
        searchRole.click();
        InputTagUtil.setData(driver, searchRole, name);

    }

    public void selectRole() {
        ActionClassUtil.actionClassClick(driver, selectRole);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public boolean ValidateCheckedBox() {
        initialCount = checkBoxSize.size();
        System.out.println(" count= " + initialCount);
        boolean box = true;
        for (WebElement checked : checkBoxSize) {
            if (!checked.isSelected()) {
                finalCount++;
            }
        }
        System.out.println("counts" + finalCount);
        if (initialCount == finalCount)
            box = false;
        return box;
    }


    public boolean buttonStatus() {
        JsExecutorUtil.scrollDown(driver,submitForm);
        return submitForm.isEnabled();
    }


    public void validatePermission(DataTable table) {
        List<Map<String, String>> modulePermissions = table.asMaps();
        for (Map<String, String> row : modulePermissions) {
            String moduleName = row.get("Module");
            String permissions = row.get("Permissions");
            WebElement moduleRow = moduleNames.findElement(By.xpath("(//th[text()='" + moduleName + "'])[2]/parent::tr"));
            String[] permissionList = permissions.split(",\\s*");
            for (String permissionsList : permissionList) {
                String permission = permissionsList.toLowerCase();

                WebElement checkbox = moduleRow.findElement(By.xpath(".//td[label[input[@value='" + permission + "']]]/label/input"));
                assert checkbox.isSelected();
            }
        }

    }
}