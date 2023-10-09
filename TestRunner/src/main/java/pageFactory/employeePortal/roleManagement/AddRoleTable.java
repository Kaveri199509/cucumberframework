package pageFactory.employeePortal.roleManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtils.ActionClassUtil;
import utility.WebDriverUtils;

import java.util.ArrayList;
import java.util.List;

public class AddRoleTable {
    WebDriver driver;
    @FindBy(xpath = "//*[@id='users-accordion']")
    private WebElement roleManagement;
    @FindBy(xpath = "//button[contains(text(),'Add Role')]")
    private WebElement addRoleButton;
    @FindBy(xpath = "//thead")
    private WebElement roleHeader;
    @FindBy(xpath = "//tbody")
    private WebElement modulesName;
    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkBox;
    @FindBy(xpath = "//table")
    private WebElement table;
    ArrayList<String> oldTab;

    ArrayList<String> newTab;
    public AddRoleTable(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void roleManagementClick() throws InterruptedException {
        oldTab =new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(oldTab.get(0));
        Thread.sleep(2000);
        ActionClassUtil.actionClassClick(driver,roleManagement);
    }
    public void addRoleButton() {
        ActionClassUtil.actionClassClick(driver,addRoleButton);
    }

    public boolean  getAllHeader(List<String> header) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,roleHeader);
        String allHeadersText=roleHeader.getText();
        boolean allHeader =true;
        for(String e:header){
            if (!allHeadersText.contains(e)){
                allHeader=false;
                break;
            }

        }return allHeader;

    }

    public boolean  getAllModule(List<String> module) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,modulesName);
        String allHeadersText=modulesName.getText();
        boolean allModules =true;
        for(String e:module){
            if (!allHeadersText.contains(e)){
                allModules=false;
                break;
            }

        }return allModules;

    }

    public int getAllCheckbox() {
        return checkBox.size();

    }




}


