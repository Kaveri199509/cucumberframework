package pageFactory.employeePortal;

import constants.LogImplementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WebDriverUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDashboard {

    private WebDriver driver;
    private ArrayList<String> oldTab;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[1]/div[1]")
    private WebElement logo;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[1]/div[2]/div/div/div[1]/label/div")
    private WebElement profileImg;

    @FindBy(xpath = "/html/head/title")
    private WebElement title;

    @FindBy(xpath = "//ul[@class='space-y-1.5 pt-5']/li[1]")
    private WebElement dashboard;

    @FindBy(xpath = "//ul[@class='space-y-1.5 pt-5']/li[2]")
    private WebElement roleManagement;

    @FindBy(xpath = "//ul[@class='space-y-1.5 pt-5']/li[3]")
    private WebElement employeeManagement;

    @FindBy(xpath = "//ul[@class='space-y-1.5 pt-5']/li[4]")
    private WebElement attandance;

    @FindBy(xpath = "//ul[@class='space-y-1.5 pt-5']/li[5]")
    private WebElement timesheet;

    @FindBy(xpath = "//ul[@class='space-y-1.5 pt-5']/li[6]")
    private WebElement leaveManagement;

    @FindBy(xpath = "//ul[@class='space-y-1.5 pt-5']/li[7]")
    private WebElement holidayCalender;

    @FindBy(xpath = "//ul[@class='space-y-1.5 pt-5']/li[8]")
    private WebElement policies;

    @FindBy(xpath = "//ul[@class='space-y-1.5 pt-5']/li[9]")
    private WebElement faq;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div[1]/div/svg/path")
    private WebElement sideDrawerArrow;

    @FindBy(xpath = "//ul[@class='space-y-1.5 pt-5']")
    private WebElement sideDrawer;

    public EmployeeDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isElementVisible(WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, element);
        return element.isDisplayed();
    }

    public boolean isLogoDisplayed() {
        oldTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(oldTab.get(0));
        boolean isLogoVisible = isElementVisible(logo);
        LogImplementation.info("EmployeePortel Logo is visible : " + isLogoVisible);
        return isLogoVisible;
    }

    public boolean isProfileDisplayed() {
        boolean isProfileVisible = isElementVisible(profileImg);
        LogImplementation.info("Employee profile is visible: " + isProfileVisible);
        return isProfileVisible;
    }

    public String getText(WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, element);
        String text = element.getText();
        System.out.println("text : " + text);
        return text;
    }

    public String getText(String drawerName) {
        WebElement element = getWebElement(drawerName);
        if (element != null) {
            return element.getText();
        } else {
            // Handle the case where the element is null (e.g., log an error or return a default value).
            return "Element not found";
        }
    }


    public boolean isComponentClickable(String component) {
        oldTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(oldTab.get(0));
        WebElement element = getWebElement(component);

        // Check if element is not null before calling isEnabled()
        if (element != null) {
            return element.isEnabled();
        } else {
            // Handle the case where the element is null (e.g., log an error or return false).
            return false;
        }
    }


    public boolean isIconAvailable(String component) {
        oldTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(oldTab.get(0));
        WebElement element = getWebElement(component);

        if (element != null) {
            List<WebElement> svg = element.findElements(By.tagName("svg"));
            return !svg.isEmpty() && svg.size() == 1;
        } else {
            return false;
        }
    }


    private WebElement getWebElement(String drawerName) {
        WebElement element = null;
        switch (drawerName) {
            case "Dashboard":
                element = dashboard;
                break;
            case "Role Management":
                element = roleManagement;
                break;
            case "Employee Management":
                element = employeeManagement;
                break;
            case "Attendance":
                element = attandance;
                break;
            case "Timesheet":
                element = timesheet;
                break;
            case "Leave Management":
                element = leaveManagement;
                break;
            case "Holiday Calendar":
                element = holidayCalender;
                break;
            case "Policies":
                element = policies;
                break;
            case "FAQ":
                element = faq;
                break;
        }
        return element;
    }
}
