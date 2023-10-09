package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features ="@target/rerun.txt",
        glue = "stepDefinitions",
        dryRun = false,
        monochrome = true)
public class TestRunnerRerun extends AbstractTestNGCucumberTests {

}
