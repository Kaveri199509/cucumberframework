package pageFactory.employeePortal.employeeLoginLogout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ConfigFileReader;
import utility.TestUtils.ActionClassUtil;
import utility.TestUtils.JsExecutorUtil;

import java.util.ArrayList;

public class EmployeeLogout {

    @FindBy(xpath = "(//div[@class='card card-side bg-base-100 p-3'])[1]")
    private WebElement div;
    WebDriver driver;
    @FindBy(xpath = "//strong[@class='text-lg']")
    private WebElement navButton;

    @FindBy(xpath = "(//div[@class='flex'])[3]/div")
    private WebElement logOutButton;

    @FindBy(xpath = "//div[@role='button']")
    private WebElement choseLogOutAccount;

    @FindBy(xpath = "(//div[@class='flex'])[2]")
    private WebElement profileButton;
    ArrayList<String> oldTab;
    ArrayList<String> newTab;

    public EmployeeLogout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDiv() {
        ActionClassUtil.actionClassClick(driver, div);
    }

    public boolean isDropdownClosed() {
        return logOutButton.isDisplayed();
    }

    public void profile() {
        oldTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(oldTab.get(0));
        ActionClassUtil.actionClassClick(driver, navButton);
    }

    public boolean logOut() {
        ActionClassUtil.actionClassClick(driver, logOutButton);
        newTab = new ArrayList<>(driver.getWindowHandles());
        if (newTab.size() == 1) {
            System.out.println("newTab.size() = " + newTab.size());
            return false;
        }
        driver.switchTo().window(newTab.get(1));
        JsExecutorUtil.jsExecutorClick(driver, choseLogOutAccount);
        oldTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(oldTab.get(0));
        JsExecutorUtil.refreshBrowser(driver);
        return true;
    }

    public void profileClick() throws InterruptedException {
        ActionClassUtil.actionClassClick(driver, profileButton);
    }

    public boolean profileUrl() {
        String currentUrl = driver.getCurrentUrl();
        ConfigFileReader configFileReader = new ConfigFileReader();
        String url = configFileReader.getApplicationUrl();
        String concat = url.concat("/Profile/Profile");
        if (currentUrl.equalsIgnoreCase(concat)) {
            return true;
        }
        return false;
    }
}
