package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WebDriverUtils;

public class ButtonUtil {

    private ButtonUtil(){}
    // For page object model...

    // Click event
    public static void selectButtonClickEvent(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, locator);
        driver.findElement(locator).click();
    }

    // Submit event
    public static void selectButtonSubmitEvent(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, locator);
        driver.findElement(locator).submit();
    }

    // reset button
    public static void resetButton(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, locator);
        driver.findElement(locator).clear();
    }

    // button Enabled
    public static boolean isButtonEnable(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, locator);
        return driver.findElement(locator).isEnabled();
    }

    // For page factory model...


    //Click event
    public static void selectButtonClickEvent(WebDriver driver, WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, element);
        element.click();
    }

    // Submit event
    public static void selectButtonSubmitEvent(WebDriver driver, WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, element);
        element.submit();
    }

    // reset button
    public static void resetButton(WebDriver driver, WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, element);
        element.clear();
    }

    // button Enabled
    public static boolean isButtonEnable(WebDriver driver, WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, element);
       return element.isEnabled();
    }

}
