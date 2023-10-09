package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SmartWaits {
    private SmartWaits(){}

    public static WebDriverWait getWaitDuration(WebDriver webDriver, int waitDuration){
      return new WebDriverWait(webDriver, Duration.ofSeconds(waitDuration));

    }

    // For page object model...
    public static void explicitWait(WebDriverWait wait, By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // For page factory model...
    public static void explicitWait(WebDriverWait wait, WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
