package stepDefinitions;

import constants.LogImplementation;
import dataBaseOperation.sqlDB.DeleteAllData;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;
import stepDefinitions.browser.*;
import stepDefinitions.enums.BrowserType;
import stepDefinitions.enums.OperatorType;
import utility.ConfigFileReader;
import utility.MoveAndRenameFolder;

import java.io.IOException;
import java.time.Duration;

public class BrowserHelper<T> {
    public WebDriver driver;
    private static int updateExtentPropertyCount = 0;
    public static ThreadLocal<WebDriver> tdriver= new ThreadLocal<>();
    public String browserType;
    public T revDauPage;
    public BrowserHelper(){

    }
    public BrowserHelper(T t) {
        revDauPage = t;
    }
    ConfigFileReader configFileReader;

    @Before(order = 0)
    public void getPropertyValues() throws IOException, SAXException {
        configFileReader = new ConfigFileReader();
        MoveAndRenameFolder.renameFolder();
        String browser = System.getProperty("browser");
        if (browser == null || browser.equalsIgnoreCase("")) {
            browserType = configFileReader.getBrowserType();
        } else {
            browserType = browser;
        }
        LogImplementation.info("browserType = " + browserType);
    }

    @Before(order = 1, value = "@Desktop")
    public void setUpDesktop() {
        driver = getBrowserType(browserType, OperatorType.DESKTOP);
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Before(order = 1, value = "@Iphone6")
    public void setUpIphone6(){
        driver = getBrowserType(browserType, OperatorType.IPHONE_6);
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Before(order = 1, value = "@Iphone6Plus")
    public void setUpIphone6Plus(){
        driver = getBrowserType(browserType, OperatorType.IPHONE_6_PLUS);
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Before(order = 1, value = "@Iphone8Plus")
    public void setUpIphone8Plus(){
        driver = getBrowserType(browserType, OperatorType.IPHONE_8_PLUS);
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Before(order = 1, value = "@IPad")
    public void setUpIPad(){
        driver = getBrowserType(browserType, OperatorType.IPAD);
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Before(order = 1, value = "@IPadLandscape")
    public void setUpIPadLandscape(){
        driver = getBrowserType(browserType, OperatorType.IPAD_LANDSCAPE);
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Before(order = 1, value = "@Samsung")
    public void setUpSamsung(){
        driver = getBrowserType(browserType, OperatorType.GALAXY_S7);
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Before(order = 1, value = "@Iphone11")
    public void setUpIphone11(){
        driver = getBrowserType(browserType, OperatorType.IPHONE_11);
        driver.get(configFileReader.getApplicationUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    private WebDriver getBrowserType(String browserType, OperatorType operatorType) {
        switch (BrowserType.valueOf(browserType)) {
            case CHROME:
               tdriver = ChromeBrowser.getDriver(operatorType);
                break;
            case FIREFOX:
               tdriver = FireFoxBrowser.getDriver(operatorType);
                break;
            case INTERNET_EXPLORER:
               tdriver = InternetExplorerBrowser.getDriver(operatorType);
                break;
            case EDGE:
                tdriver = EdgeBrowser.getDriver(operatorType);
                break;
            case SAFARI:
                tdriver = SafariBrowser.getDriver(operatorType);
                break;
            default:
                LogImplementation.error("Invalid Browser selected" + browserType);
                tdriver = ChromeBrowser.getDriver(operatorType);
                break;
        }
        LogImplementation.info("getDriverName = "+ tdriver);
        return getDriverName();
    }

    public static WebDriver getDriverName() {
        return tdriver.get();
    }

    @After(order = 2)
    public void closeBrowser(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
        if (updateExtentPropertyCount++ == 0) {
            configFileReader = new ConfigFileReader();
            configFileReader.updateSystemProperty(driver);
        }
        driver.quit();
    }

    @After(order = 2, value = "@NewRole")
    public void deleteRole(){
        configFileReader.ConfigFileReader configFileReader=new configFileReader.ConfigFileReader();
        DeleteAllData.deleteData(configFileReader.getTableName(),"role_name","Manager");
    }

    @After(order = 2, value = "@NewPolicy")
    public void deletePolicies(){
        DeleteAllData.deleteData("policy_docs","policy_name","Test");
    }


}