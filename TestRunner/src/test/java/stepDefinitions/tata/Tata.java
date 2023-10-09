package stepDefinitions.tata;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageFactory.tata.TataPFM;
import stepDefinitions.BrowserHelper;
import utility.WebDriverUtils;

public class Tata {
    public WebDriver driver;
    TataPFM tataPFM;

    public TataPFM getTataPFM(){
        driver = WebDriverUtils.getDriver();
        BrowserHelper<TataPFM> tataPFMBrowserHelper=new BrowserHelper<>(new TataPFM(driver));
        return tataPFMBrowserHelper.revDauPage;
    }

    @Then("I check Tata logo is present in login page {string}")
    public void i_check_tata_logo_is_present_in_login_page(String title) {
        tataPFM = new TataPFM(BrowserHelper.getDriverName());
        Assert.assertEquals(title,tataPFM.get_logo());
    }
    @When("I entered {string} and {string}")
    public void i_entered_and(String username, String password) throws InterruptedException {
        tataPFM = new TataPFM(BrowserHelper.getDriverName());
        tataPFM.set_username(username);
        Thread.sleep(4000);
        tataPFM.set_password(password);
        Thread.sleep(4000);
    }

    @Then("I checked in the remember me check box.")
    public void i_checked_in_the_remember_me_check_box() throws InterruptedException {
        tataPFM = new TataPFM(BrowserHelper.getDriverName());
        tataPFM.click_checkedBox();
        Thread.sleep(4000);

    }
    @Then("I click on Sign In button.")
    public void i_click_on_sign_in_button() throws InterruptedException {
        tataPFM = new TataPFM(BrowserHelper.getDriverName());
        Thread.sleep(4000);
        tataPFM.getSignInButton();
        Thread.sleep(4000);
    }
    @Then("Title of tata home page {string}")
    public void title_of_tata_home_page(String title) {
        tataPFM = new TataPFM(BrowserHelper.getDriverName());
        Assert.assertEquals(title,tataPFM.getTitle());
    }


    @When("I entered {string}")
    public void i_entered(String username) throws InterruptedException {
        tataPFM = new TataPFM(BrowserHelper.getDriverName());
        tataPFM.set_username(username);
        Thread.sleep(3000);
        tataPFM.copyPaste();
        Thread.sleep(3000);
    }
}