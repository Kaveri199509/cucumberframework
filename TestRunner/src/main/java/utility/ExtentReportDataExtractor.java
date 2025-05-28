package utility;

import dataBaseOperation.exception.GlobalException;
import dataBaseOperation.sqlDB.InsertData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExtentReportDataExtractor {
    public ExtentReportDataExtractor(){}
    List<Map<String, Object>> rows = new ArrayList<>();
    Map<String, Object> rowData = new HashMap<>();

    public void readFile(String filePath,String tableName) throws IOException {
        try {
            // Read the HTML file
            File input = new File(filePath);
            Document doc = Jsoup.parse(input, "UTF-8");

            // Extract and process data from the HTML file
            Elements testResults = doc.select("body > div > div > div.vcontainer > div");
            for (Element result : testResults) {

                String[] startDateTime = result.select("div.container-fluid.p-4.view.dashboard-view > div:nth-child(1) > div:nth-child(1) > div > div").text().replace(",", "").split(" ", 2);
                String startDateTimeColumn = startDateTime[0];
                Timestamp startDateTimeValue = convertDateFormat(startDateTime[1]);
                rowData.put(startDateTimeColumn,startDateTimeValue);

                String[] endDateTime = result.select("div.container-fluid.p-4.view.dashboard-view > div:nth-child(1) > div:nth-child(2) > div > div").text().replace(",", "").split(" ", 2);
                String endDateTimeColumn = endDateTime[0];
                Timestamp endDateTimeValue = convertDateFormat(endDateTime[1]);
                rowData.put(endDateTimeColumn,endDateTimeValue);

                String feature = result.select("div.container-fluid.p-4.view.dashboard-view > div:nth-child(2) > div:nth-child(1) > div > div.card-footer").text();
                String featureSkipped="feature";
                 formatData(feature,featureSkipped);

                String scenario = result.select("div.container-fluid.p-4.view.dashboard-view > div:nth-child(2) > div:nth-child(2) > div > div.card-footer").text();
                String scenarioSkipped="scenario";
                formatData(scenario,scenarioSkipped);

                String steps = result.select("div.container-fluid.p-4.view.dashboard-view > div:nth-child(2) > div:nth-child(3) > div > div.card-footer").text();
                System.out.println(steps);
                String stepSkipped="steps";
                formatData(steps,stepSkipped);

                rows.add(rowData);
                System.out.println("Rows = "+rows);

                InsertData.insertDataIntoTable(rows,tableName);

            }
        } catch (IOException e) {
            throw new GlobalException("");
        }
    }


    private static Timestamp convertDateFormat(String inputDateString) {
        Timestamp formattedDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy hh:mm:ss a");
            Date dateTime = dateFormat.parse(inputDateString);
            formattedDate = new Timestamp(dateTime.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }


    public Map<String, Object> formatData(String data,String skipped) {
        String[] feature = data.replace(",", "").split(" ");
        String passedValue = feature[0];
        String passedColumn = feature[1] + feature[2];
        rowData.put(passedColumn, passedValue);
        String failedValue = feature[3];
        String failedColumn = feature[4] + feature[5];
        rowData.put(failedColumn, failedValue);
        String skippedValue = feature[6];
        String skippedColumn = skipped+feature[7];
        rowData.put(skippedColumn, skippedValue);
        return rowData;
    }
}

