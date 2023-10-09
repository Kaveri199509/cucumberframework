package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.WebDriverUtils;

import java.util.List;

public class SelectDropDown {
    private SelectDropDown(){}

    // Select DropDown value
    // For page object model...

    // select DropdownBy TextVisible
    public static void selectOptionFromDropdownByOptionText(WebDriver driver, By locator, String optionText) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(optionText);
    }

    //  select DropdownByValue
    public static void selectOptionFromDropdownByValue(WebDriver driver, By locator, String optionValue) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByValue(optionValue);
    }

   // Select DropdownByIndex
    public static void selectOptionFromDropdownByIndex(WebDriver driver, By locator, int optionIndex) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByIndex(optionIndex);
    }

    //select multiple options from a dropdown

    // Select multiple option by visible text
    public static void selectMultipleOptionsFromDropdownByOptionText(WebDriver driver,By locator, List<String> optionValues) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Select dropdown = new Select(driver.findElement(locator));
        for (String value : optionValues) {
            dropdown.selectByValue(value);
        }
    }

    // Select multiple option ByValue
    public static void selectMultipleOptionsFromDropdownByValue(WebDriver driver,By locator, List<String> optionValues) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Select dropdown = new Select(driver.findElement(locator));
        for (String value : optionValues) {
            dropdown.selectByValue(value);
        }
    }

    // Select multiple option ByIndex
    public static void selectMultipleOptionsFromDropdownByIndex(WebDriver driver,By locator, List<Integer> optionValues) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Select dropdown = new Select(driver.findElement(locator));
        for (Integer value : optionValues) {
            dropdown.selectByIndex(value);
        }
    }

    // Clear select option
    // By visible text
    public static void deSelectByVisibleText(WebDriver driver, By locator,String optionText) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.deselectByVisibleText(optionText);
    }

    //by Value
    public static void deSelectByValue(WebDriver driver, By locator,String optionValue) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.deselectByValue(optionValue);
    }

   //by IndexValue
    public static void deSelectByIndex(WebDriver driver, By locator,int IndexValue) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.deselectByIndex(IndexValue);
    }

    // Clear all select option
    public static void deSelect(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.deselectAll();
    }

    // Select element supports multiple selection options or not
    public static boolean isMultipleEnabled(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Select dropdown = new Select(driver.findElement(locator));
         return dropdown.isMultiple();
    }

    // For page factory model...

    // select DropdownBy TextVisible
    public static void selectOptionFromDropdownByOptionText(WebDriver driver, WebElement element, String optionText) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(optionText);
    }

    //  select DropdownByValue
    public static void selectOptionFromDropdownByValue(WebDriver driver,WebElement element, String optionValue) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Select dropdown = new Select(element);
        dropdown.selectByValue(optionValue);
    }

    // Select DropdownByIndex
    public static void selectOptionFromDropdownByIndex(WebDriver driver,WebElement element, int optionIndex) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Select dropdown = new Select(element);
        dropdown.selectByIndex(optionIndex);
    }

    //select multiple options from a dropdown

    // Select multiple option by visible text
    public static void selectMultipleOptionsFromDropdownByOptionText(WebDriver driver,WebElement element,List<String> optionValues) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Select dropdown = new Select(element);
        for (String value : optionValues) {
            dropdown.selectByValue(value);
        }
    }

    // Select multiple option ByValue
    public static void selectMultipleOptionsFromDropdownByValue(WebDriver driver,WebElement element,List<String> optionValues) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Select dropdown = new Select(element);
        for (String value : optionValues) {
            dropdown.selectByValue(value);
        }
    }

    // Select multiple option ByIndex
    public static void selectMultipleOptionsFromDropdownByIndex(WebDriver driver,WebElement element,List<Integer> optionValues) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Select dropdown = new Select(element);
        for (Integer value : optionValues) {
            dropdown.selectByIndex(value);
        }
    }

    // Clear select option
    // By visible text
    public static void deSelectByVisibleText(WebDriver driver,WebElement element,String optionText) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Select dropdown = new Select(element);
        dropdown.deselectByVisibleText(optionText);
    }

    //by Value
    public static void deSelectByValue(WebDriver driver,WebElement element, String optionValue) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Select dropdown = new Select(element);
        dropdown.deselectByValue(optionValue);
    }

    //by IndexValue
    public static void deSelectByIndex(WebDriver driver,WebElement element,int IndexValue) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Select dropdown = new Select(element);
        dropdown.deselectByIndex(IndexValue);
    }

    // Clear all select option
    public static void deSelect(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Select dropdown = new Select(element);
        dropdown.deselectAll();
    }

    // Select element supports multiple selection options or not
    public static boolean isMultipleEnabled(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Select dropdown = new Select(element);
        return dropdown.isMultiple();
    }


}
