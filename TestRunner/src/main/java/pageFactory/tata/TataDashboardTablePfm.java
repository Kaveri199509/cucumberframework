package pageFactory.tata;

import constants.LogImplementation;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtils.DateTimeFormat;

import java.util.List;

public class TataDashboardTablePfm {
    WebDriver driver;

    public TataDashboardTablePfm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WebElement dashboardTable;
    List<WebElement> utilizeInterfaceUpComingRow;
    List<WebElement> utilizeInterfaceUpComingCol;
    WebElement utilizeInterfaceUpComingHeader;
    WebElement dateTimeSection;
    WebElement tableHeadSection;
    public void getDivHeader(int divNumber) {
        String div = "(//*[@class='row']//div[@class='col-md-6'])[" + divNumber + "]";
        LogImplementation.info("div = " + div);
        WebElement divHead = driver.findElement(By.xpath(div));
        WebElement headElement = divHead.findElement(By.tagName("h3"));
        List<WebElement> spanList = headElement.findElements(By.tagName("span"));
        tableHeadSection = spanList.get(0);
        dateTimeSection = spanList.get(1);
        dashboardTable = divHead.findElement(By.tagName("table"));
        LogImplementation.info("dashboardTable.isDisplayed() = " + dashboardTable.isDisplayed());
        WebElement tableHead = dashboardTable.findElement(By.tagName("thead"));
        utilizeInterfaceUpComingHeader = tableHead;
        LogImplementation.info("utilizeInterfaceUpComingHeader.getText() = " + utilizeInterfaceUpComingHeader.getText());
        WebElement tablebody = dashboardTable.findElement(By.tagName("tbody"));
        utilizeInterfaceUpComingRow = tablebody.findElements(By.tagName("tr"));
        utilizeInterfaceUpComingCol = tablebody.findElements(By.tagName("td"));
    }
    public int getRow() {
        return utilizeInterfaceUpComingRow.size();
    }

    public int getCol() {
        return utilizeInterfaceUpComingCol.size();
    }

    public String[] getHeaderText() {
        return utilizeInterfaceUpComingHeader.getText().split(" ");
    }

    public boolean getIsTableVisible() {
        LogImplementation.info("dashboardTable = " + dashboardTable);
        return dashboardTable.isDisplayed();
    }

//    public void checkAllDataOfTable() {
//            for (WebElement col : utilizeInterfaceUpComingCol) {
//                Assert.assertFalse(col.getText().isEmpty());
//            }
//    }

//    public boolean getDateTimeValidator(String expectedFormat) {
//        String actualString = dateTimeSection.getText();
//        LogImplementation.info("actualString = " + actualString);
//        String[] dateTimeList = actualString.split(" To ");
//        for (String dateTime : dateTimeList) {
//            boolean isDateTimeFormateValid = DateTimeFormat.dateTime(dateTime, expectedFormat);
//            LogImplementation.info("isDateTimeFormateValid = " + isDateTimeFormateValid);
//            return isDateTimeFormateValid;
//        }

//        return false;
//    }

    public boolean getIsTableNameAvailable() {
        String tableName = tableHeadSection.getText();
        LogImplementation.info("tableName.isEmpty() = " + tableName.isEmpty());
        return true;
    }

}
