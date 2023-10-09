package utility.TestUtils;

import constants.Constants;
import constants.LogImplementation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTimeFormat {

    private DateTimeFormat() {

    }

    public static boolean dateTime(String actualDateTime, String expectedFormat) {
        switch (expectedFormat) {
            case Constants.YYYY_MM_DD_HH_MM_SS:
                return dateTimeValidator(actualDateTime, expectedFormat);
            case Constants.YY_MM_DD_HH_MM_SS:
                return dateTimeValidator(actualDateTime, expectedFormat);
            case Constants.DD_MM_YYYY_HH_MM_SS:
                return dateTimeValidator(actualDateTime, expectedFormat);
            case Constants.DD_MM_YY_HH_MM_SS:
                return dateTimeValidator(actualDateTime, expectedFormat);
            case Constants.YYYY_MM_DD_HH_MM:
                return dateTimeValidator(actualDateTime, expectedFormat);
            case Constants.YY_MM_DD_HH_MM:
                return dateTimeValidator(actualDateTime, expectedFormat);
            case Constants.DD_MM_YYYY_HH_MM:
                return dateTimeValidator(actualDateTime, expectedFormat);
            case Constants.DD_MM_YY_HH_MM:
                return dateTimeValidator(actualDateTime, expectedFormat);
            default:
                LogImplementation.info("Date Time Format is not available");
                return false;
        }
    }


    private static boolean dateTimeValidator(String actualDateTime, String expectedFormat) {
        boolean isValidFormat = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(expectedFormat);
        try {
            LocalDateTime.parse(actualDateTime, formatter);
            isValidFormat = true;
        } catch (Exception e) {
            // Parsing failed, try next format
        }

        if (isValidFormat) {
            LogImplementation.info("The date-time string matches one of the provided formats.");
        } else {
            LogImplementation.info("The date-time string does not match any of the provided formats.");
        }
        return isValidFormat;
    }
}
