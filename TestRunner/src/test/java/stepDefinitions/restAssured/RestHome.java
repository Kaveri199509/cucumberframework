package stepDefinitions.restAssured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Constants;
import constants.LogImplementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.RestObjects;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageFactory.revDau.RevDauDashboardPf;
import stepDefinitions.BrowserHelper;
import utility.ConfigFileReader;
import utility.WebDriverUtils;

import java.util.HashMap;
import java.util.Map;

public class RestHome {

    public WebDriver driver;
    RevDauDashboardPf revDauDashboardPf;
    ConfigFileReader configFileReader;
    Response response;

    public RevDauDashboardPf getRevDauDashboardpf(){
        driver = WebDriverUtils.getDriver();
        BrowserHelper<RevDauDashboardPf> revDauDashboardPageBrowserHelper=new BrowserHelper<>(new RevDauDashboardPf(driver));
        return revDauDashboardPageBrowserHelper.revDauPage;
    }


    @When("I send get request for about section with path Url {string}")
    public void i_send_get_request_for_about_section_with_path_url(String path_url) {
        response=RestObjects.getData(configFileReader.getBaseUrl(),path_url,null);
        LogImplementation.info("Get response  status code = "+response.getStatusCode());
        response.getStatusCode();


    }
    @Then("response should be {int}")
    public void response_should_be(int status) {
        Assert.assertEquals(status,response.getStatusCode());
    }




//    @Then("I click on about section for get method response should be {int}")
//    public void i_click_on_about_section_for_get_method_response_should_be(int status) {
//        Response response=RestObjects.getData
//                (configFileReader.getBaseUrl(),"components-pages-about-about-module-ngfactory.js",null);
//        LogImplementation.info("Get response  status code = "+response.getStatusCode());
//        Assert.assertEquals(status, response.getStatusCode());
//        LogImplementation.info("!!!!!response = " + response.asString());
//
//    }
    @Given("I fill get Quote form for post method {string} and {string} and {string} and {string}")
    public void i_fill_get_quote_form_for_post_method_and_and_and(String name, String email, String mobile, String message) {
        String json =  getRequestBody(name,email,mobile,message);
        Response response = RestObjects.postData("https://meteor-hypnotic-antelope.glitch.me/","sendFormData",null,json );
        LogImplementation.info("Post response  status code= "+response.getStatusCode());
        LogImplementation.info("Post response= "+response.asString());
        LogImplementation.info("response.asString() = " + response.asString());
        LogImplementation.info("response.getStatusCode() = " + response.getStatusCode());
    }
    private final String getRequestBody(String name, String email, String mobile, String message) {
        Map<String, String> map = new HashMap<>();
        map.put(Constants.NAME, name);
        map.put(Constants.EMAIL, email);
        map.put(Constants.MOBILE, mobile);
        map.put(Constants.MESSAGE, message);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = " ";
        try {
            json = objectMapper.writeValueAsString(map);
            LogImplementation.info(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;

    }
}


