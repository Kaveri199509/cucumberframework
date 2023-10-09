package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WebDriverUtils;

public class PasswordUtil {
    private PasswordUtil(){}

    // For page object model...
    public static void clearPassword(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        driver.findElement(locator).clear();
    }
    public static void enterPassword(WebDriver driver, By locator,String password) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        driver.findElement(locator).sendKeys(password);
    }
    public static boolean isPasswordVisible(WebDriver driver,By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        String fieldType = driver.findElement(locator).getAttribute("type");
        return fieldType.equalsIgnoreCase("text");
    }

    public static boolean isPasswordNotVisible(WebDriver driver,By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        String fieldType = driver.findElement(locator).getAttribute("type");
        return fieldType.equalsIgnoreCase("password");
    }
    public static boolean isPasswordEnable(WebDriver driver,By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        return driver.findElement(locator).isEnabled();
    }

    public static boolean enterPasswordLength(WebDriver driver, By locator,int expectedPasswordLength) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        String enteredPasswordLength= driver.findElement(locator).getAttribute("value");
        int passwordLengths=enteredPasswordLength.length();
        return  expectedPasswordLength==passwordLengths;
    }

    //  For page factory model

    public static void clearPassword(WebDriver driver, WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.clear();
    }
    public static void enterPassword(WebDriver driver,WebElement element,String password) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.sendKeys(password);
    }
    public static boolean isPasswordVisible(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        String fieldType = element.getAttribute("type");
        return fieldType.equalsIgnoreCase("text");
    }

    public static boolean isPasswordNotVisible(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        String fieldType = element.getAttribute("type");
        return fieldType.equalsIgnoreCase("password");
    }
    public static boolean isPasswordEnable(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        return element.isEnabled();
    }

    public static boolean enterPasswordLength(WebDriver driver,WebElement element,int expectedPasswordLength) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        String enteredPasswordLength=element.getAttribute("value");
        int passwordLengths=enteredPasswordLength.length();
        return  expectedPasswordLength==passwordLengths;
    }
}
