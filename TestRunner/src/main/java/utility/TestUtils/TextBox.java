package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WebDriverUtils;

public class TextBox {
    private TextBox(){}
    // For page object model...
    public static boolean isTextBoxEnabled(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        return driver.findElement(locator).isEnabled();
    }
    public static void setTextBoxData(WebDriver driver, By locator, String message) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        driver.findElement(locator).sendKeys(message);
    }

    public static String getTextBoxData(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        return driver.findElement(locator).getText();
    }

    public static void clearTextBoxData(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        driver.findElement(locator).clear();
    }

    // For page factory model...

    public static boolean isTextBoxEnabled(WebDriver driver, WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        return element.isEnabled();
    }
    public static void setTextBoxData(WebDriver driver,WebElement element, String message) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.sendKeys(message);
    }

    public static String getTextBoxData(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        return element.getText();
    }

    public static void clearTextBoxData(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.clear();
    }

}

