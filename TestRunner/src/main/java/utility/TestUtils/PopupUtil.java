package utility.TestUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WebDriverUtils;

public class PopupUtil {
    private PopupUtil(){}

    // For page object model...
    public static void accept(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.accept();
    }
    public static void dismiss(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.dismiss();
    }

    public static void insetDataTOAlertBox(WebDriver driver, By locator,String alertText) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(alertText);
        promptAlert.accept();
    }
     public static void getPopupText(WebDriver driver,By locator){
         WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
         Alert alert = driver.switchTo().alert();
         alert.getText();
    }

    // For page factory model...

    public static void accept(WebDriver driver, WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.accept();
    }
    public static void dismiss(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.dismiss();
    }

    public static void insetDataTOAlertBox(WebDriver driver,WebElement element,String alertText) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(alertText);
        promptAlert.accept();
    }
    public static void getPopupText(WebDriver driver,WebElement element){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Alert alert = driver.switchTo().alert();
        alert.getText();
    }

}
