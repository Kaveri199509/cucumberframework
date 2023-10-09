package stepDefinitions.webElement;

import constants.LogImplementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.RevDauQuotePage;
import stepDefinitions.BrowserHelper;
import utility.ConfigFileReader;
import utility.WebDriverUtils;

public class RevDauQuote {
    public WebDriver driver;
    RevDauQuotePage revDauQuotePage;
    ConfigFileReader configFileReader;
    public RevDauQuotePage getRevDauQuotePage(){
        driver = WebDriverUtils.getDriver();
        BrowserHelper<RevDauQuotePage> revDauDashboardPageBrowserHelper=new BrowserHelper<>(new RevDauQuotePage(driver));
        return revDauDashboardPageBrowserHelper.revDauPage;
    }


    @When("I click on Get_Quote Section")
    public void i_click_on_Get_Quote_Section() {
        revDauQuotePage=new RevDauQuotePage(BrowserHelper.getDriverName());
        revDauQuotePage.getGetQuote();
    }

    @Then("Get_Quote Section Text must be {string}")
    public void get_quote_Section_Text_must_be(String response) throws InterruptedException {
        revDauQuotePage=new RevDauQuotePage(BrowserHelper.getDriverName());
        String quoteTitle=revDauQuotePage.getQuoteTitle();
        LogImplementation.info("quoteTitle is = " + quoteTitle);
        String quoteText=response.replaceAll("\\s"," ");
        String quoteTitleText= quoteTitle.replace("\\s","").replaceAll("\n"," ");
        Assert.assertEquals(quoteText,quoteTitleText);

    }
    @Given("I entered {string} and {string} and {string} and {string}")
    public void i_entered_and_and_and(String name, String email, String mobile, String message) throws InterruptedException {
        revDauQuotePage=new RevDauQuotePage(BrowserHelper.getDriverName());
        revDauQuotePage.setName(name);
        Thread.sleep(2000);
        revDauQuotePage.setEmail(email);
        Thread.sleep(2000);
        revDauQuotePage.setMobile_no(mobile);
        Thread.sleep(2000);
        revDauQuotePage.setMessage(message);
        Thread.sleep(2000);
        revDauQuotePage.setSubmit();

    }
    @Then("the output should be {string}")
    public void the_output_should_be(String response) throws InterruptedException {
        revDauQuotePage=new RevDauQuotePage(BrowserHelper.getDriverName());
        Assert.assertEquals(response,revDauQuotePage.getSuccess());
        Thread.sleep(4000);
    }
}
