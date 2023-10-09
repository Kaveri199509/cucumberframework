package stepDefinitions;/*
package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utility.ConfigFileReader;
import utility.WebDriverUtils;

import java.io.IOException;

public class Hooks extends Base64 {
    WebDriver driver = WebDriverUtils.getDriver();
    private static int updateExtentPropertyCount = 0;
    private ConfigFileReader configFileReader;

    @After(order = 1)
    public void takeScreenshotOnFailure(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
        if (updateExtentPropertyCount++ == 0) {
            configFileReader = new ConfigFileReader();
            configFileReader.updateSystemProperty(driver);
        }
        driver.close();
    }




}
*/
