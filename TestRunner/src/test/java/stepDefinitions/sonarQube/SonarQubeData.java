package stepDefinitions.sonarQube;

import io.cucumber.java.en.When;
import pageFactory.sonar.SonarQubeDataPFM;
import stepDefinitions.BrowserHelper;
import utility.ExtentReportDataExtractor;

import java.io.IOException;
import java.text.ParseException;

public class SonarQubeData {
    SonarQubeDataPFM sonarQubeDataPFM;
    @When("i insert sonar data in the database")
    public void i_insert_sonar_data_in_the_database() throws ParseException, IOException {

        String chrome="C:\\Users\\lenovo\\.jenkins\\workspace\\Automation_Jobs\\QA_Automation_CHROME\\TestRunner\\ExtentReports\\SparkReport_ 21\\Reports\\Spark.html";
        String firefox="C:\\Users\\lenovo\\.jenkins\\workspace\\Automation_Jobs\\QA_Automation_FIREFOX\\TestRunner\\ExtentReports\\SparkReport_ 21\\Reports\\Spark.html";
        String  edge="C:\\Users\\lenovo\\.jenkins\\workspace\\Automation_Jobs\\QA_Automation_EDGE\\TestRunner\\ExtentReports\\SparkReport_ 21\\Reports\\Spark.html";

        ExtentReportDataExtractor extentReportDataExtractor = new ExtentReportDataExtractor();
        ExtentReportDataExtractor extentReportDataExtractor1 = new ExtentReportDataExtractor();
        ExtentReportDataExtractor extentReportDataExtractor2 = new ExtentReportDataExtractor();

        extentReportDataExtractor.readFile(chrome,"chromeReport");
        extentReportDataExtractor1.readFile(firefox,"fireFoxReport");
        extentReportDataExtractor2.readFile(edge,"edgeReport");
    sonarQubeDataPFM =new SonarQubeDataPFM(BrowserHelper.getDriverName());
    sonarQubeDataPFM.tab();
    sonarQubeDataPFM.getSonarData();
    }
}
