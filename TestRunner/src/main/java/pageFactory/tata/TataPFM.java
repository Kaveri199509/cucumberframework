package pageFactory.tata;

import constants.LogImplementation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtils.ActionClassUtil;
import utility.TestUtils.ButtonUtil;
import utility.TestUtils.InputTagUtil;
import utility.TestUtils.JsExecutorUtil;
import utility.WebDriverUtils;

import java.net.URI;

public class TataPFM {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"frmLogin\"]/div[4]/div[2]/button")
    public WebElement signInButton;

   @FindBy(xpath ="//*[@id = 'remember']")
    public WebElement rememberCheckBox;

    @FindBy(css = ".login-logo")
    public WebElement logo;

    public TataPFM(WebDriver driverName) {
        this.driver = driverName;
        PageFactory.initElements(driver, this);
    }

    public String  get_logo(){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,logo);
        String style = logo.getCssValue("background-image");
        String imageUrl = style.split("url\\(\"")[1].split("\"\\)")[0];
        try {
            URI image = new URI(imageUrl);
            return image.getPath().substring(image.getPath().lastIndexOf('/') + 1);
        } catch (Exception e) {
            LogImplementation.info(e.getMessage());
        }

       return null;
    }

    public void set_username(String userId){
        InputTagUtil.setData(driver,username,userId);
    }

    public void set_password(String pass){
        InputTagUtil.setData(driver,password,pass);
    }

    public void click_checkedBox(){
        JsExecutorUtil.jsExecutorClick(driver,rememberCheckBox);

    }
    public void getSignInButton(){
        ButtonUtil.selectButtonClickEvent(driver,signInButton);
    }

    public String getTitle(){
         return driver.getTitle();
    }

    public void copyPaste() throws InterruptedException {
       ActionClassUtil.actionClassSelectClear(driver,username);
       Thread.sleep(3000);
        ActionClassUtil.rightClickAndRefresh(driver,signInButton);
        Thread.sleep(3000);
    }

}
