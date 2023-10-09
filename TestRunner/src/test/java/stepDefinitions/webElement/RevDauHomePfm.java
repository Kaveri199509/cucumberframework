package stepDefinitions.webElement;

import constants.LogImplementation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageFactory.revDau.RevDauDashboardPf;
import stepDefinitions.BrowserHelper;
import utility.WebDriverUtils;

public class RevDauHomePfm {
    public WebDriver driver;
    RevDauDashboardPf revDauDashboardPf;

    public RevDauDashboardPf getRevDauDashboardpf(){
        driver = WebDriverUtils.getDriver();
        BrowserHelper<RevDauDashboardPf> revDauDashboardPageBrowserHelper=new BrowserHelper<>(new RevDauDashboardPf(driver));
        return revDauDashboardPageBrowserHelper.revDauPage;
    }

    @Then("I check the title {string}")
    public void i_check_the_title(String title) {
        LogImplementation.info("String="+title);
        revDauDashboardPf= new RevDauDashboardPf(BrowserHelper.getDriverName());
        revDauDashboardPf.headerText();
        Assert.assertEquals(title,revDauDashboardPf.get_tittle());
    }

    @Then("I check RevDau logo is present in home page")
    public void i_check_RevDau_logo_is_present_in_home_page() throws InterruptedException {
        revDauDashboardPf= new RevDauDashboardPf(BrowserHelper.getDriverName());
        Assert.assertTrue(revDauDashboardPf.get_logo());
        Thread.sleep(4000);
    }

    @When("I click on about section")
    public void i_click_on_about_section() throws InterruptedException {
        revDauDashboardPf= new RevDauDashboardPf(BrowserHelper.getDriverName());
        revDauDashboardPf.click_about();
        Thread.sleep(4000);
    }

    @Then("Validating the Why RevDau section text- {string}")
    public void validatingTheWhyRevDauSectionText(String aboutSection) {
        revDauDashboardPf= new RevDauDashboardPf(BrowserHelper.getDriverName());
        LogImplementation.info("aboutSection = " + aboutSection);
        String text1=aboutSection.replaceAll("\\s"," ");
        String text=revDauDashboardPf.getAboutSectionTxt();
        String str= text.replace("\\s","").replaceAll("\n"," ");
        Assert.assertEquals(text1,str);
    }
}
