package pageFactory.tata;

import constants.LogImplementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtils.ButtonUtil;
import utility.TestUtils.JsExecutorUtil;
import utility.TestUtils.SelectDropDown;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TataAllDevicePFM {
    WebDriver driver;

    public static final String TBODY = "tbody";
    @FindBy(xpath = "//a[@class='small-box bg-yellow']")
    WebElement totalDeviceDiv;
    @FindBy(xpath = "//select[@name='tableChartIn_length']")
    WebElement dropDownMenu;
    @FindBy(xpath = "//input[@type='search']")
    WebElement searchBar;
    @FindBy(xpath = "//table[@id='tableChartIn']")
    WebElement dataTable;
    @FindBy(xpath = "//button[@class='btn btn-box-tool']")
    WebElement downloadExcel;
    @FindBy(xpath = "//button[@id='download_pdf']")
    WebElement downloadExcel2;

    public TataAllDevicePFM(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }


    public void clickDiv(){
        JsExecutorUtil.jsExecutorClick(driver,totalDeviceDiv);
    }

    public void getOnDashboardPage(){
        LogImplementation.info("driver = " + driver);
    }

    public void setDropDownValue(int dropDownValue) {
        SelectDropDown.selectOptionFromDropdownByValue(driver,dropDownMenu, String.valueOf(dropDownValue));
        LogImplementation.info("dataTable.getText() = " + dataTable.getText());
        getTableLength();
    }


    public int getTableLength() {
        WebElement tbody = dataTable.findElement(By.tagName(TBODY));
        List<WebElement> tableRow = tbody.findElements(By.tagName("tr"));
        for(WebElement row:tableRow) {
            LogImplementation.info("tableRow. = " + row.getText());
        }
        return tableRow.size();
    }

    public List<String> getHeaderText() throws InterruptedException {
        List<String> columnHeader = new ArrayList<>();
        WebElement thead = dataTable.findElement(By.tagName("thead"));
        List<WebElement> th = thead.findElements(By.tagName("th"));
        for (WebElement header : th){
            columnHeader.add(header.getText());
            JsExecutorUtil.jsExecutorClick(driver,header);
            Thread.sleep(2000);
            LogImplementation.info("header.getText() = " + header.getText());
        }
        return columnHeader;
    }

    public boolean isDataAvailable(){
        WebElement tbody = dataTable.findElement(By.tagName(TBODY));
        List<WebElement> tableRow = tbody.findElements(By.tagName("tr"));
        for(WebElement row:tableRow) {
            List<WebElement> tableColumn = row.findElements(By.tagName("td"));
            LogImplementation.info("tableRow = " + row.getText());
            for (WebElement col : tableColumn) {
                LogImplementation.info("col.getText() = " + col.getText());

            }
        }
        return true;
    }

    public void doSearch(String string) throws InterruptedException {
        searchBar.sendKeys(string);
        Thread.sleep(3000);
    }

    public String checkText() throws InterruptedException {
        WebElement tbody = dataTable.findElement(By.tagName(TBODY));
        List<WebElement> tableRow = tbody.findElements(By.tagName("tr"));
        String resultText = tableRow.get(0).getText();
        LogImplementation.info("resultText = " + resultText);
        Thread.sleep(2000);
        return resultText;
    }

    public void setDownloadExcel() throws InterruptedException {
        ButtonUtil.selectButtonClickEvent(driver,downloadExcel);
        Thread.sleep(1000);
        ButtonUtil.selectButtonClickEvent(driver,downloadExcel2);
        Thread.sleep(1000);
    }

    public static Boolean isFileDownloaded() {
        boolean flag = false;
        String downloadDir = "C:\\Users\\lenovo\\Downloads";
        File dir = new File(downloadDir);

        // Filter for XLS files
        FilenameFilter filter = (dir1, name) -> name.toLowerCase().endsWith(".xls");

        // Get all XLS files in the directory
        File[] xlsFiles = dir.listFiles(filter);

        // Sort files by last modified timestamp
        Arrays.sort(xlsFiles, Comparator.comparingLong(File::lastModified).reversed());

        if (xlsFiles != null && xlsFiles.length > 0) {
            File mostRecentXLSFile = xlsFiles[0];  // Get the most recent XLS file
            LogImplementation.info("Most recent XLS file: " + mostRecentXLSFile.getName());
            LogImplementation.info("Path: " + mostRecentXLSFile.getAbsolutePath());
            flag= true;
        } else {
            LogImplementation.info("No XLS files found in the directory.");
        }
        return flag;
    }
}
