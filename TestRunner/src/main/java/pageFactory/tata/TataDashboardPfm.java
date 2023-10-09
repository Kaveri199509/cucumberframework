package pageFactory.tata;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WebDriverUtils;

public class TataDashboardPfm {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"reportBody\"]/div[1]/div[1]/a/div[1]/h3")
    public WebElement totalDevice;

    @FindBy(xpath = "//*[@id=\"reportBody\"]/div[1]/div[2]/a/div[1]/h3")
    public WebElement totalSNMPDevice;

    @FindBy(xpath = "//*[@id=\"reportBody\"]/div[1]/div[3]/a/div[1]/h3")
    public WebElement totalFLowDevice;

//    @FindBy(xpath = "//*[@id=\"reportBody\"]/div[1]/div[4]/a/div[1]/div[2]/h3[1]")
    @FindBy(xpath = "//*[@class=\"inner\"]/div[2]/h3[1]")
    public WebElement netflowDevice;

    @FindBy(xpath = "//*[@class=\"inner\"]/div[2]/h3[2]")
    public WebElement snmpDevice;

    @FindBy(xpath = "//*[@class=\"inner\"]/div[2]/h3[3]")
    public WebElement div4Total;

    public TataDashboardPfm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getTotalDevice(){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,totalDevice);
        return totalDevice.getText();
    }

    public String getTotalSnmpDevice(){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,totalSNMPDevice);
        return totalSNMPDevice.getText();
    }

    public String getTotalFlowDevice(){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,totalFLowDevice);
        return totalFLowDevice.getText();
    }

    public String getTotalNetFLowDevice(){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,netflowDevice);
        return netflowDevice.getText();
    }

    public String getSnmpDevice(){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,snmpDevice);
        return snmpDevice.getText();
    }

    public String getDiv4Total(){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,div4Total);
        return div4Total.getText();
    }
}
