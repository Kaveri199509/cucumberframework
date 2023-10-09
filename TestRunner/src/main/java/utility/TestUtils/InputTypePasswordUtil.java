package utility.TestUtils;

import constants.LogImplementation;
import gherkin.deps.net.iharder.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WebDriverUtils;


public class InputTypePasswordUtil {
    private InputTypePasswordUtil(){}

    // For page object model...

    public static boolean isInputTypePasswordEnabled(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        return driver.findElement(locator).isEnabled();
    }

    public static void setInputTypePasswordData(WebDriver driver, By locator, String password) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        driver.findElement(locator).sendKeys(password);
    }

    public static String getInputTypePasswordData(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        return driver.findElement(locator).getText();
    }

    public static void clearInputTypePasswordData(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        driver.findElement(locator).clear();
    }

    public static void setEncryptInputTypePasswordData(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        byte[] encodedBytes = Base64.encodeBytesToBytes("Password".getBytes());
        driver.findElement(locator).sendKeys(new String(encodedBytes));
    }

    public static String getDecryptInputTypePasswordData(WebDriver driver, By locator) {
        try {
            WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
            String password = driver.findElement(locator).getText();
            byte[] decodedBytes = Base64.decode(password);
            return new String(decodedBytes);
        }catch (Exception e){
            LogImplementation.info(e.getMessage());
            return null;
        }
    }
 // For page factory model
 public static boolean isInputTypePasswordEnabled(WebDriver driver, WebElement element) {
     WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
     return element.isEnabled();
 }

    public static void setInputTypePasswordData(WebDriver driver,WebElement element, String password) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.sendKeys(password);
    }

    public static String getInputTypePasswordData(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        return  element.getText();
    }

    public static void clearInputTypePasswordData(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.clear();
    }

    public static void setEncryptInputTypePasswordData(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        byte[] encodedBytes = Base64.encodeBytesToBytes("Password".getBytes());
        element.sendKeys(new String(encodedBytes));
    }

    public static String getDecryptInputTypePasswordData(WebDriver driver,WebElement element) {
        try {
            WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
            String password = element.getText();
            byte[] decodedBytes = Base64.decode(password);
            return new String(decodedBytes);
        }catch (Exception e){
           LogImplementation.info(e.getMessage());
            return null;
        }
    }



}
