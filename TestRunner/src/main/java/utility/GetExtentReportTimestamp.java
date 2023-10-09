package utility;


import constants.LogImplementation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetExtentReportTimestamp {

    public static String getDateFromExtentReport() {
        String htmlFilePath = "C:\\Users\\lenovo\\Desktop\\QA-Automation\\TestRunner\\ExtentReports\\SparkReport_ 21\\Reports\\Spark.html"; // Replace this with the actual path to your HTML file
        String outputDateFormat = "d_MMM_YY HH_mm_ss";

        try {
            File htmlFile = new File(htmlFilePath);
            Document doc = Jsoup.parse(htmlFile, "UTF-8");

            String timestamp = extractTimestampFromHTML(doc);
            String formattedDate = convertDateFormat(timestamp, outputDateFormat);
            LogImplementation.info("Timestamp from HTML: " + timestamp);
            LogImplementation.info("Formatted Date: " + formattedDate);
            return formattedDate;
        } catch (IOException e) {
            LogImplementation.info("Error reading HTML file: " + e.getMessage());
        }
        return null;
    }

    private static String extractTimestampFromHTML(Document doc) {
        String timestamp = null;
        // Modify the CSS selector to match the HTML element that contains the timestamp
        Elements elements = doc.select("ul.nav-right li.m-r-10 span.badge-primary");
        if (!elements.isEmpty()) {
            Element timestampElement = elements.last();
            timestamp = timestampElement.text();
        }

        return timestamp;
    }

    private static String convertDateFormat(String inputDateString, String outputDateFormat) {
        String formattedDate = null;
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMM d, yyyy hh:mm:ss a");
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputDateFormat);

        try {
            Date date = inputFormat.parse(inputDateString);
            formattedDate = outputFormat.format(date);
        } catch (ParseException e) {
            LogImplementation.info("Error parsing date: " + e.getMessage());
        }

        return formattedDate;
    }
}
