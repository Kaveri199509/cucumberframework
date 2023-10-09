package utility;

import com.aventstack.extentreports.service.ExtentService;
import constants.Constants;
import constants.LogImplementation;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private static final Properties properties = new Properties();
    private static final Properties extentProperties = new Properties();
    private final String propertyFilePath = "configs//configuration.properties";
    private final String extentPropertyFilePath = "src//main//resources//extent.properties";
    Properties prop;

    public ConfigFileReader() {
        try (BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
            properties.load(reader);
        } catch (IOException e) {
            String errorMessage = "Error while reading configuration file: " + e.getMessage();
            throw new ConfigFileReaderException(errorMessage, e);
        }
    }


    public static boolean getHeadlessBrowser() {
        String headless = properties.getProperty(Constants.HEADLESS_BROWSER);
        boolean headlessBrowser = false;
        LogImplementation.info("headless = " + headless);
        if (headless.equalsIgnoreCase("true")) {
            headlessBrowser = true;
        }
        return headlessBrowser;
    }

    public static String getBrowserVersion() {
        String browserVersion = properties.getProperty(Constants.BROWSER_VERSION);
        return browserVersion;
    }

    public static String getBaseUrl() {
        String baseUrl = properties.getProperty(Constants.BASE_URL);
        return baseUrl;
    }

    public static String getPlatformName() {
        String platformName = properties.getProperty(Constants.PLATFORM_NAME);
        return platformName;
    }

    public static String getMobile() {
        String mobileList = properties.getProperty(Constants.MOBILES);
        return mobileList;
    }

    public String getApplicationUrl() {
        String url = properties.getProperty(Constants.APP_URL);
        LogImplementation.info("Application Url =" + url);
        if (url != null) return url;
        else
            throw new ConfigFileReaderException("url not specified in the Configuration.properties file.");
    }

    public String getPropertyFilePath() {
        String path = properties.getProperty(Constants.PATH);
        if (path == null) {
            throw new ConfigFileReaderException("Path not specified in the Configuration.properties file.");
        }
        return path;
    }

    public Double getPropertyFileSizeLimit() {
        String fileSizeLimit = properties.getProperty(Constants.FILE_SIZE_LIMIT);
        return Double.parseDouble(fileSizeLimit);
    }

    public String getBrowserType() {
        String browser = properties.getProperty(Constants.BROWSER);
        return browser;
    }

    public int minWait() {
        String minWait = properties.getProperty(Constants.MIN_WAIT);
        return Integer.parseInt(minWait);
    }

    public int maxWait() {
        String maxWait = properties.getProperty(Constants.MAX_WAIT);
        return Integer.parseInt(maxWait);
    }

    public int avgWait() {
        String avgWait = properties.getProperty(Constants.AVG_WAIT);
        return Integer.parseInt(avgWait);
    }

    public String employeeID() {
        String id = properties.getProperty(Constants.EMPLOYEE_USER_ID);
        if (id == null) {
            throw new ConfigFileReaderException("EMPLOYEE_USER_ID not specified in the Configuration.properties file.");
        }
        return id;
    }


    public String employeePassword() {
        String password = properties.getProperty(Constants.EMPLOYEE_USER_PSWRD);
        if (password == null) {
            throw new ConfigFileReaderException("EMPLOYEE_USER_PASSWORD not specified in the Configuration.properties file.");
        }
        return password;
    }
    public String adminID() {
        String id = properties.getProperty(Constants.ADMIN_ID);
        if (id == null) {
            throw new ConfigFileReaderException("ADMIN_ID not specified in the Configuration.properties file.");
        }
        return id;
    }

    public String adminPassword() {
        String password = properties.getProperty(Constants.ADMIN_PSWRD);
        if (password == null) {
            throw new ConfigFileReaderException("ADMIN_Password not specified in the Configuration.properties file.");
        }
        return password;
    }
    public String rmUserID() {
        String id = properties.getProperty(Constants.RM_ID);
        if (id == null) {
            throw new ConfigFileReaderException("RM_ID not specified in the Configuration.properties file.");
        }
        return id;
    }

    public String rmUserPassword() {
        String password = properties.getProperty(Constants.RM_PSWRD);
        if (password == null) {
            throw new ConfigFileReaderException("RM_PASSWORD not specified in the Configuration.properties file.");
        }
        return password;
    }

    public String hrUserID() {
        String id = properties.getProperty(Constants.HR_ID);
        if (id == null) {
            throw new ConfigFileReaderException("HR_ID not specified in the Configuration.properties file.");
        }
        return id;
    }

    public String hrUserPassword() {
        String password = properties.getProperty(Constants.HR_PSWRD);
        if (password == null) {
            throw new ConfigFileReaderException("HR_PASSWORD not specified in the Configuration.properties file.");
        }
        return password;
    }





    public void updateSystemProperty(WebDriver driver) throws IOException {
        try (BufferedReader extentReader = new BufferedReader(new FileReader(extentPropertyFilePath))) {
            Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
            ExtentService.getInstance().setSystemInfo("User", System.getProperty("user.name"));
            ExtentService.getInstance().setSystemInfo("OsName", System.getProperty("os.name"));
            ExtentService.getInstance().setSystemInfo("Platform", capabilities.getPlatformName().toString());
            ExtentService.getInstance().setSystemInfo("OsVersion", System.getProperty("os.version"));
            ExtentService.getInstance().setSystemInfo("OsArchitecture", System.getProperty("os.arch"));
            ExtentService.getInstance().setSystemInfo("BrowserName", capabilities.getBrowserName());
            ExtentService.getInstance().setSystemInfo("BrowserVersion", capabilities.getBrowserVersion());
            extentProperties.load(extentReader);
        }
    }
}