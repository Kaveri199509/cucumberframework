package pageFactory.employeePortal.employeeLoginLogout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtils.ActionClassUtil;
import utility.TestUtils.InputTagUtil;
import utility.TestUtils.JsExecutorUtil;
import utility.WebDriverUtils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class EmployeeLogin {
    WebDriver driver;
    @FindBy(xpath = "//button[contains(text(),'Microsoft Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@name='loginfmt']")
    private WebElement userEmail;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement nextSignInButton;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement password;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkbox;

    @FindBy(xpath = "//input[@type='button']")
    private WebElement notButton;

    @FindBy(xpath = "//strong[@class='text-lg']")
    private WebElement profileName;

    @FindBy(xpath = "//div[@id='otherTile']")
    private WebElement reLoginAccount;
    ArrayList<String> newTab;
    ArrayList<String> oldTab;


    public EmployeeLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void msLoginButton() {
        ActionClassUtil.actionClassClick(driver, loginButton);
    }

    public void setUserName(String usrEmail) {
        newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        InputTagUtil.setData(driver, userEmail, usrEmail);
    }

    public void clickNextSignIn() {
        ActionClassUtil.actionClassClick(driver, nextSignInButton);
    }

    public void setUserPassword(String pass) {
        InputTagUtil.setData(driver, password, pass);
    }

    public void clickCheckBox() {
        JsExecutorUtil.jsExecutorClick(driver, checkbox);
    }

    public void noRemember() {
        JsExecutorUtil.jsExecutorClick(driver, notButton);

    }

    public String userProfile() {
        oldTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(oldTab.get(0));
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, profileName);
        return profileName.getText();

    }


    public void reLogin() {
        oldTab = new ArrayList<>(driver.getWindowHandles());
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.switchTo().window(oldTab.get(1));
        JsExecutorUtil.jsExecutorClick(driver,reLoginAccount);


    }

}