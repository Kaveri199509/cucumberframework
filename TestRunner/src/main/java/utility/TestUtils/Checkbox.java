package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WebDriverUtils;

public class Checkbox {
    private Checkbox(){}

    // For object page model...
    public static boolean isCheckBoxSelected(WebDriver driver, By locator){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        WebElement checkBoxElement =driver.findElement(locator);
        return checkBoxElement.isSelected();
    }

    public static void CheckBoxSelect(WebDriver driver, By locator){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        WebElement checkBoxElement =driver.findElement(locator);
        checkBoxElement.click();
    }



    public static boolean isCheckBoxDisplayed(WebDriver driver, By locator){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        WebElement checkBoxElement =driver.findElement(locator);
        return checkBoxElement.isDisplayed();
    }

    public static boolean isCheckBoxEnabled(WebDriver driver, By locator){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        WebElement checkBoxElement =driver.findElement(locator);
        return checkBoxElement.isEnabled();
    }

    public static void clearData(WebDriver driver,By locator){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        driver.findElement(locator).clear();
    }

    // For page factory model...

    public static boolean isCheckBoxSelected(WebDriver driver,WebElement element){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        return element.isSelected();
    }

    public static boolean isCheckBoxDisplayed(WebDriver driver,WebElement element){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        return element.isDisplayed();
    }

    public static boolean isCheckBoxEnabled(WebDriver driver,WebElement element){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        return element.isEnabled();
    }

    public static void clearData(WebDriver driver,WebElement element){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.clear();
    }
    public static void CheckBoxSelect(WebDriver driver,WebElement element){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.click();

    }


}
