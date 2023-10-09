package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WebDriverUtils;

public class LabelUtil {
    // For page object model
    private LabelUtil(){}


    public static boolean labelIsNotPresent(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, locator);
        return driver.findElement(locator).isDisplayed();

    }
    //  For page factory model


    public static boolean labelIsNotPresent(WebDriver driver, WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, element);
        return element.isDisplayed();
    }
}