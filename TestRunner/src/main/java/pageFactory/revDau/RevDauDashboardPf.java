package pageFactory.revDau;

import constants.LogImplementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtils.ActionClassUtil;
import utility.WebDriverUtils;

public class RevDauDashboardPf {

    WebDriver driver;
    @FindBy(xpath = "//header[@class='header-area header-area-2']")
    public WebElement header;


    @FindBy(xpath = "//a[@class=\"navbar-brand\"]")
    public WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'About')]")
    public WebElement about;

    @FindBy(xpath = "//button[@class='navbar-toggler']")
    WebElement navButton;

    @FindBy(xpath = "//div[@class='intri-content']//h2[@class='title']")
    public WebElement aboutSectionTxt;

    public RevDauDashboardPf(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String get_tittle() {
        LogImplementation.info("RevDau title is present in home page");
        return driver.getTitle();

    }

    public boolean get_logo() {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, logo);
        Boolean isLogoDisplayed = this.logo.isDisplayed();
        LogImplementation.info("RevDau logo is present in the home page = " + isLogoDisplayed);
        return isLogoDisplayed;
    }

    public void click_about() {
        ActionClassUtil.actionClassClick(driver,about);
        LogImplementation.info("Click action perform on about section");
    }

    public String getAboutSectionTxt() {
        String txt = aboutSectionTxt.getText();
        LogImplementation.info("About section title is present");
        return txt;
    }

    public void headerText() {
        for (WebElement li : header.findElements(By.tagName("li"))) {
            LogImplementation.info("li.getText() = " + li.getText());
        }
    }

}


