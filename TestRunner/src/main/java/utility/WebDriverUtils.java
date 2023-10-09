package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WebDriverUtils {
    private static WebDriver driver;
    static ConfigFileReader configFileReader=new ConfigFileReader();

    public WebDriverUtils(WebDriver driver) {
        this.driver=driver;
    }

    public static WebDriver setDriver(WebDriver webDriver) {
        driver=webDriver;
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new AssertionError("Driver is null. Initialize driver before calling this method.");
        }
        return driver;
    }

    public static WebDriverWait getWaitDuration(WebDriver webDriver,int waitDuration){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitDuration));
        return wait;
    }

    public static void explicitWait(WebDriverWait wait,By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void isLocatorVisibleByFluentWait(WebDriver driver,By locator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(configFileReader.maxWait()))
                .pollingEvery(Duration.ofSeconds(configFileReader.minWait()))
                .ignoring(Exception.class);


         wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    public static void isLocatorVisibleByFluentWait(WebDriver driver,WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(configFileReader.maxWait()))
                .pollingEvery(Duration.ofSeconds(configFileReader.minWait()))
                .ignoring(Exception.class);

        wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return  wait.until(ExpectedConditions.visibilityOf(webElement));
            }
        });

    }

}

