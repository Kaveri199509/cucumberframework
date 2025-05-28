package pageFactory.sonar;

import dataBaseOperation.sqlDB.InsertData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtils.ActionClassUtil;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SonarQubeDataPFM {
    WebDriver driver;


    @FindBy(xpath ="//button[@id='tab-overall']")
    private WebElement overallTab;

    @FindBy(xpath ="//*[@id=\"context-navigation\"]/div[1]/div[1]/div[1]/div/a/span")
    private WebElement projectNames;

    @FindBy(xpath ="//div[@class='sw-body-sm-highlight sw-mb-1']")
    private WebElement dateTimes;

    @FindBy(xpath ="(//div[@class='sw-body-md sw-flex sw-items-center'])[1]")
    private WebElement bug;

    @FindBy(xpath ="(//div[@class='sw-body-md sw-flex sw-items-center'])[3]")
    private WebElement vulnerability ;

    @FindBy(xpath ="//span[@class='sw-heading-lg']")
    private WebElement qualityGates;

    @FindBy(xpath ="(//div[@class='sw-body-md sw-flex sw-items-center'])[2]")
    private WebElement codeSmell;

    @FindBy(xpath ="(//div[@class='sw-body-md sw-flex sw-items-center sw-mb-3'])[2]")
    private WebElement duplication;
    List<Map<String, Object>> rows = new ArrayList<>();
    Map<String, Object> rowData = new HashMap<>();
    public SonarQubeDataPFM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void getSonarData() throws ParseException {
      String projectName =projectNames.getText();
      String qualityGate=qualityGates.getText();
        System.out.println(qualityGate);
      String regex="\\r?\\n|\\r";
      String analysisDateTime=dateTimes.getText().replaceAll("\\bat\\b|,","");
      SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy h:mm a");
      Date dateTime = dateFormat.parse(analysisDateTime);
      Timestamp timestamp = new Timestamp(dateTime.getTime());
      String[] bugsValue=bug.getText().split(regex);
      String bugValue=bugsValue[0].replaceAll("[A-E]","");
      String bugColumn=bugsValue[1];
      String[] vulnerabilitiesValues=vulnerability.getText().split(regex);
      String vulnerabilitiesValue=vulnerabilitiesValues[0].replaceAll("[A-E]","");
      String vulnerabilitiesColumn=vulnerabilitiesValues[1];

        String[] codeDuplication=duplication.getText().split(regex);
        String duplicationValue=codeDuplication[0];
        System.out.println(duplicationValue);
        String duplicationColumn=codeDuplication[1];
        System.out.println(duplicationColumn);
        String[] codeSmells=codeSmell.getText().split(regex);
        String codeSmellValue=codeSmells[0];
        String codeSmellColumn=codeSmells[1].replaceAll("\\s", "");

        rowData.put("projectName",projectName);
        rowData.put("analysisDateTime", timestamp);
        rowData.put("qualityGate", qualityGate);
        rowData.put(bugColumn, bugValue);
        rowData.put(vulnerabilitiesColumn, vulnerabilitiesValue);
        rowData.put(codeSmellColumn, codeSmellValue);
        rowData.put(duplicationColumn, duplicationValue);
        rows.add(rowData);
        InsertData.insertDataIntoTable(rows,"sonarQubeReport");
    }

    public void tab(){
        ActionClassUtil.actionClassClick(driver,overallTab);
    }
}
