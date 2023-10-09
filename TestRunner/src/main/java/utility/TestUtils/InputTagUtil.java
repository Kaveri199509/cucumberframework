package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WebDriverUtils;

public class InputTagUtil {
    private InputTagUtil(){}
    // For page object model...

    public static boolean isInputTagEnabled(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        return driver.findElement(locator).isEnabled();
    }
    public static void setData(WebDriver driver, By locator, String message) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        driver.findElement(locator).sendKeys(message);
    }

    public static String getData(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
       return driver.findElement(locator).getText().toString();
    }

    public static void clearData(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        driver.findElement(locator).clear();
    }

    // For page factory model...

    public static boolean isInputTagEnabled(WebDriver driver, WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        return element.isEnabled();
    }
    public static void setData(WebDriver driver, WebElement element, String message) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.sendKeys(message);
    }

    public static String getData(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        return element.getText().toString();
    }

    public static void clearData(WebDriver driver, WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.clear();
    }


}
