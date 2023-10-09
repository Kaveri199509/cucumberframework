package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WebDriverUtils;

public class RadioButtonUtil {
    private RadioButtonUtil(){}

    // For page object model...
    public static void selectRadioButton(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        driver.findElement(locator).click();
    }

    public static void clearRadioButton(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        driver.findElement(locator).clear();
    }

    public static boolean checkedRadioButton(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        return  driver.findElement(locator).isSelected();
    }

    public static boolean isRadioButtonEnable(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        return  driver.findElement(locator).isEnabled();
    }

    // For page factory model...
    public static void selectRadioButton(WebDriver driver, WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.click();
    }

    public static void clearRadioButton(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.clear();
    }

    public static boolean checkedRadioButton(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        return element.isSelected();
    }

    public static boolean isRadioButtonEnable(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        return element.isEnabled();
    }

}

