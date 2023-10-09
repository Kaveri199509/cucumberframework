package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/rerun.txt"},
        features = {"src/test/features"},
        tags = "~@MongoDB or ~@department or ~@employee or ~@Dashboard or ~@dashboardQuote or @Tata",
        glue = "stepDefinitions",
        dryRun = false,
        monochrome = true,
        publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
    /*private static int count = 1;

    public static void main(String[] args) throws IOException {
        JUnitCore jUnitCore = new JUnitCore();
        DirectoryMover.moveFolder();
        Result result = jUnitCore.run(TestRunner.class);

        while (!result.wasSuccessful() && count < Constants.MAX_RERUN) {
            LogImplementation.info("Executing Test = " + count++);
            result = jUnitCore.run(TestRunnerRerun.class);
        }
        DirectoryMover.renameFolder();
    }*/

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}