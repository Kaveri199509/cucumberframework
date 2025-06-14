package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/rerun.txt"},
		features = {"src/test/features"},
		tags = "@Desktop", // Default tags, you can remove this line if not needed
		glue = "stepDefinitions",
		dryRun = false,
		monochrome = true,
		publish = true)

public class TestngRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
