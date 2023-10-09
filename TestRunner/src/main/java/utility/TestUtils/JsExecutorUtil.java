package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WebDriverUtils;

public class JsExecutorUtil {
    private JsExecutorUtil(){}
    // for page object model
    public static void jsExecutorClick(WebDriver driver, By locator){
        WebElement element =driver.findElement(locator);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();",element);
    }

    public static void scrollDown(WebDriver driver, By locator){
        WebElement element =driver.findElement(locator);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
       jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void refreshBrowser(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("history.go(0)");
    }

    // for page factory model
    public static void jsExecutorClick(WebDriver driver,WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();",element );
    }

    public static void scrollDown(WebDriver driver, WebElement element){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }

}
