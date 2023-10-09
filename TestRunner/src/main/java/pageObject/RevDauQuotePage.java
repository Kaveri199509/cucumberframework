package pageObject;

import constants.LogImplementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigFileReader;
import utility.TestUtils.ActionClassUtil;
import utility.TestUtils.ButtonUtil;
import utility.TestUtils.InputTagUtil;
import utility.WebDriverUtils;

public class RevDauQuotePage {
    WebDriver  driver;
    ConfigFileReader configFileReader;
    By quoteResponse=By.xpath("//a[text()='Get A Quote']");
    By quoteTitle=By.xpath("//h2[text()='Estimate For Your Projects.']");
    By isSuccess=By.xpath("//*[@id=\"contact-form\"]/ngb-alert");
    By txtName=By.xpath("//*[@id=\"contact-form\"]/div[1]/input");
    By txtEmail=By.xpath("//*[@id=\"contact-form\"]/div[2]/input");
    By txtMobile_no=By.xpath("//*[@id=\"contact-form\"]/div[3]/input");
    By txtMessage=By.xpath("//*[@id=\"contact-form\"]/div[4]/textarea");
    By submit=By.xpath("//*[@id=\"contact-form\"]/div[4]/button");

    public RevDauQuotePage(WebDriver driver){
        this.driver = driver;
    }
    public void getGetQuote(){
        WebDriverWait wait= WebDriverUtils.getWaitDuration(driver,60);
        WebDriverUtils.explicitWait(wait,quoteResponse);
        ActionClassUtil.actionClassClick(driver,quoteResponse);
       LogImplementation.info("get quote section clicked");
    }

    public void getUrl(){
        configFileReader=new ConfigFileReader();
        driver.get(configFileReader.getApplicationUrl());

    }

    public String getQuoteTitle(){
        WebDriverWait wait= WebDriverUtils.getWaitDuration(driver,60);
        WebDriverUtils.explicitWait(wait,quoteTitle);
        String quoteTitleText=driver.findElement(quoteTitle).getText();
        LogImplementation.info("About QuoteTitle text found : "+quoteTitleText);
        return quoteTitleText;

    }
    public void setName(String name) {
        InputTagUtil.setData(driver,txtName,name);
        LogImplementation.info("Name entered in the name text box");
    }

    public void setEmail(String email){
        InputTagUtil.setData(driver,txtEmail,email);
        LogImplementation.info("Email entered in the email text box");
    }

    public void setMobile_no(String mobileNo) {
        InputTagUtil.setData(driver,txtMobile_no,mobileNo);
        LogImplementation.info("Mobile_no entered in the mobile_no. text box");
    }

    public void setMessage(String message) {
        InputTagUtil.setData(driver,txtMessage,message);
        LogImplementation.info("Massage entered in the message text box");
    }

    public String getSuccess(){
        WebDriverWait wait= WebDriverUtils.getWaitDuration(driver,60);
        WebDriverUtils.explicitWait(wait,isSuccess);
        String successText=driver.findElement(isSuccess).getText();
        LogImplementation.info("Success message is present : "+successText);
        return successText;
    }
    public void setSubmit(){
        WebDriverWait wait= WebDriverUtils.getWaitDuration(driver,60);
        WebDriverUtils.explicitWait(wait,submit);
        ButtonUtil.selectButtonSubmitEvent(driver,submit);
        LogImplementation.info("Submit action perform on submit now...");
    }
}
