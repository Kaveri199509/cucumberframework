package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.WebDriverUtils;

import java.time.Duration;

public class NewTabUtil {
    private NewTabUtil(){}

    public static String getOriginalWindow(WebDriver driver){
        return driver.getWindowHandle();
    }

    public static void getBackToOldWindow(WebDriver driver){
        driver.close();
        driver.switchTo().window(getOriginalWindow(driver));
    }

    // For page object model...

    public static void openNewWindow(WebDriver driver, By locator){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        driver.findElement(locator).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String originalWindow=getOriginalWindow(driver);
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    // for page factory model...
    public static void openNewWindow(WebDriver driver, WebElement element){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        element.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String originalWindow=getOriginalWindow(driver);
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

}
