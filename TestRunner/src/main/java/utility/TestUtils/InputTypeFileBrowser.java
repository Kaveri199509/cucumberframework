package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.ConfigFileReader;
import utility.WebDriverUtils;

import java.io.File;

public class InputTypeFileBrowser {
    private InputTypeFileBrowser(){}
    static ConfigFileReader configFileReader=new ConfigFileReader();

    // For page object model...
    public static boolean isInputTypeFileEnabled(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        return driver.findElement(locator).isEnabled();
    }

    public static boolean validateFileSizeInMb(File file){
        double fileSize= (double) file.length() / (1024 * 1024) ;
        if(fileSize > configFileReader.getPropertyFileSizeLimit())
            return true;
        return false;
    }

    public static boolean validateFileExtension(String extension){
        if(extension.equals("jpg"))
            return true;

        return false;
    }
    public static String uploadInputTypeFile(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        WebElement chooseFile = driver.findElement(locator);
        String path= configFileReader.getPropertyFilePath();
        chooseFile.sendKeys(path);
        String[] extension=path.split(".");
        File file = new File(path);
        String response;
        if(driver.getPageSource().contains("File Uploaded!") &&
                validateFileExtension(extension[1]) && validateFileSizeInMb(file)) {
            response="file uploaded";
        }
        else{
            response="file not uploaded";
        }
        return response;
    }


    // For page factory model...

    public static boolean isInputTypeFileEnabled(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        return element.isEnabled();
    }

    public static String uploadInputTypeFile(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        WebElement chooseFile = element;
        String path= configFileReader.getPropertyFilePath();
        chooseFile.sendKeys(path);
        String[] extension=path.split(".");
        File file = new File(path);
        String response;
        if(driver.getPageSource().contains("File Uploaded!") &&
                validateFileExtension(extension[1]) && validateFileSizeInMb(file)) {
            response="file uploaded";
        }
        else{
            response="file not uploaded";
        }
        return response;
    }
}
