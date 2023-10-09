package stepDefinitions.browser;

import constants.LogImplementation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariOptions;
import stepDefinitions.enums.OperatorType;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserOptions<T> {
    static WebDriver driver;
    T platform;

    public BrowserOptions() {
    }

    public BrowserOptions(T t) {
        platform = t;
    }

    public void setChromePlatform(OperatorType operatorType, ChromeOptions chromeOptions) {
        String headless= System.getProperty("headless");
        if (headless==null){
            headless ="false";
        }else if (headless.equalsIgnoreCase("true")) {
            chromeOptions.addArguments("--headless");
        }
        switch (OperatorType.valueOf(operatorType.name())) {
            case MOBILE:
                chromeOptions.addArguments(BrowserUtility.getMobileResoultion());
                break;
            case DESKTOP:
                chromeOptions.addArguments(BrowserUtility.getDesktopResoultion());
                break;
            case IPHONE_6:
                chromeOptions.addArguments(BrowserUtility.getIphone6());
//                ChromeBrowser.getiPhone6Capabilities(ChromeBrowser.getChromeOptions(chromeOptions));
                break;
            case IPHONE_6_PLUS:
                chromeOptions.addArguments(BrowserUtility.getIphone6Plus());
//                ChromeBrowser.getiPhone6PlusCapabilities(ChromeBrowser.getChromeOptions(chromeOptions));
                break;
            case IPHONE_8_PLUS:
                chromeOptions.addArguments(BrowserUtility.getIphone8Plus());
//                ChromeBrowser.getiPhone8PlusCapabilities(ChromeBrowser.getChromeOptions(chromeOptions));
                break;
            case IPHONE_11:
                LogImplementation.info("Case IPHONE_11 :");
                chromeOptions.addArguments(BrowserUtility.getIphone11());
//                ChromeOptions options =  ChromeBrowser.getChromeOptions(chromeOptions);
//                ChromeBrowser.getiPhone11Capabilities(options);
                break;
            case IPAD:
                chromeOptions.addArguments(BrowserUtility.getIpad());
//                ChromeBrowser.getiPadCapabilities(ChromeBrowser.getChromeOptions(chromeOptions));
                break;
            case IPAD_LANDSCAPE:
                chromeOptions.addArguments(BrowserUtility.getIphoneLandscape());
//                ChromeBrowser.getiPadLandscapeCapabilities(ChromeBrowser.getChromeOptions(chromeOptions));
                break;
            case GALAXY_S7:
                chromeOptions.addArguments(BrowserUtility.getGalaxyS7());
//                ChromeBrowser.getGalaxyS7Capabilities(ChromeBrowser.getChromeOptions(chromeOptions));
                break;
        }
    }

    public void setEdgePlatform(OperatorType operatorType, EdgeOptions edgeOptions) {
        String headless= System.getProperty("headless");
        if (headless==null){
            headless ="false";
        }else if (headless.equalsIgnoreCase("true")){
            edgeOptions.addArguments("--headless");
        }
//        platform.setAcceptInsecureCerts(true);
        switch (OperatorType.valueOf(operatorType.name())) {
            case MOBILE:
                edgeOptions.addArguments(BrowserUtility.getMobileResoultion());
                break;
            case DESKTOP:
                edgeOptions.addArguments(BrowserUtility.getDesktopResoultion());
                edgeOptions.addArguments("InPrivate");
                break;
            case IPHONE_6:
                edgeOptions.addArguments(BrowserUtility.getIphone6());
//                EdgeBrowser.getiPhone6Capabilities(EdgeBrowser.getEdgeOptions(edgeOptions));
                break;
            case IPHONE_6_PLUS:
                edgeOptions.addArguments(BrowserUtility.getIphone6Plus());
//                EdgeBrowser.getiPhone6PlusCapabilities(EdgeBrowser.getEdgeOptions(edgeOptions));
                break;
            case IPHONE_8_PLUS:
                edgeOptions.addArguments(BrowserUtility.getIphone8Plus());
//                EdgeBrowser.getiPhone8PlusCapabilities(EdgeBrowser.getEdgeOptions(edgeOptions));
                break;
            case IPHONE_11:
                edgeOptions.addArguments(BrowserUtility.getIphone11());
//                EdgeBrowser.getiPhone11Capabilities(EdgeBrowser.getEdgeOptions(edgeOptions));
                break;
            case IPAD:
                edgeOptions.addArguments(BrowserUtility.getIpad());
//                EdgeBrowser.getiPadCapabilities(EdgeBrowser.getEdgeOptions(edgeOptions));
                break;
            case IPAD_LANDSCAPE:
                edgeOptions.addArguments(BrowserUtility.getIphoneLandscape());
//                EdgeBrowser.getiPadLandscapeCapabilities(EdgeBrowser.getEdgeOptions(edgeOptions));
                break;
            case GALAXY_S7:
                edgeOptions.addArguments(BrowserUtility.getGalaxyS7());
//                EdgeBrowser.getGalaxyS7Capabilities(EdgeBrowser.getEdgeOptions(edgeOptions));
                break;
        }
    }

    public void setFireFoxPlatform(OperatorType operatorType, FirefoxOptions firefoxOptions) {
        Logger logger = Logger.getLogger(getClass().getName());
        String headless= System.getProperty("headless");
        if (headless==null){
            headless ="false";
        }else if (headless.equalsIgnoreCase("true")) {
            firefoxOptions.addArguments("--headless");
            logger.log(Level.INFO, "Headless mode enabled.");
        }
        firefoxOptions.setAcceptInsecureCerts(true);
        switch (OperatorType.valueOf(operatorType.name())) {
            case MOBILE:
                firefoxOptions.addArguments(BrowserUtility.getMobileResoultion());
                break;
            case DESKTOP:
                firefoxOptions.addArguments(BrowserUtility.getDesktopResoultion());
                break;
            case IPHONE_6:
                firefoxOptions.addArguments(BrowserUtility.getIphone6());
//                FireFoxBrowser.getiPhone6Capabilities(FireFoxBrowser.getFirefoxOptions(firefoxOptions));
                break;
            case IPHONE_6_PLUS:
                firefoxOptions.addArguments(BrowserUtility.getIphone6Plus());
//                FireFoxBrowser.getiPhone6PlusCapabilities(FireFoxBrowser.getFirefoxOptions(firefoxOptions));
                break;
            case IPHONE_8_PLUS:
                firefoxOptions.addArguments(BrowserUtility.getIphone8Plus());
//                FireFoxBrowser.getiPhone8PlusCapabilities(FireFoxBrowser.getFirefoxOptions(firefoxOptions));
                break;
            case IPHONE_11:
                firefoxOptions.addArguments(BrowserUtility.getIphone11());
//                FireFoxBrowser.getiPhone11Capabilities(FireFoxBrowser.getFirefoxOptions(firefoxOptions));
                break;
            case IPAD:
                firefoxOptions.addArguments(BrowserUtility.getIpad());
//                FireFoxBrowser.getiPadCapabilities(FireFoxBrowser.getFirefoxOptions(firefoxOptions));
                break;
            case IPAD_LANDSCAPE:
                firefoxOptions.addArguments(BrowserUtility.getIphoneLandscape());
//                FireFoxBrowser.getiPadLandscapeCapabilities(FireFoxBrowser.getFirefoxOptions(firefoxOptions));
                break;
            case GALAXY_S7:
                firefoxOptions.addArguments(BrowserUtility.getGalaxyS7());
//                FireFoxBrowser.getGalaxyS7Capabilities(FireFoxBrowser.getFirefoxOptions(firefoxOptions));
                break;
        }
    }

    public void setInternetExplorerPlatform(OperatorType operatorType
            , InternetExplorerOptions internetExplorerOptions) {
//        if (ConfigFileReader.getHeadlessBrowser()) {
//            internetExplorerOptions.addArguments("--headless");
//        }
        internetExplorerOptions.setAcceptInsecureCerts(true);
        switch (OperatorType.valueOf(operatorType.name())) {
            case MOBILE:
//                internetExplorerOptions.addArguments("--window-size=300,450");
                break;
            case DESKTOP:
//                internetExplorerOptions.addArguments("--window-size=1920,1080");
                break;
            case IPHONE_6:
                InternetExplorerBrowser.getiPhone6Capabilities
                        (InternetExplorerBrowser.getInternetExplorerOptions(internetExplorerOptions));
                break;
            case IPHONE_6_PLUS:
                InternetExplorerBrowser.getiPhone6PlusCapabilities
                        (InternetExplorerBrowser.getInternetExplorerOptions(internetExplorerOptions));
                break;
            case IPHONE_8_PLUS:
                InternetExplorerBrowser.getiPhone8PlusCapabilities
                        (InternetExplorerBrowser.getInternetExplorerOptions(internetExplorerOptions));
                break;
            case IPHONE_11:
                InternetExplorerBrowser.getiPhone11Capabilities
                        (InternetExplorerBrowser.getInternetExplorerOptions(internetExplorerOptions));
                break;
            case IPAD:
                InternetExplorerBrowser.getiPadCapabilities
                        (InternetExplorerBrowser.getInternetExplorerOptions(internetExplorerOptions));
                break;
            case IPAD_LANDSCAPE:
                InternetExplorerBrowser.getiPadLandscapeCapabilities
                        (InternetExplorerBrowser.getInternetExplorerOptions(internetExplorerOptions));
                break;
            case GALAXY_S7:
                InternetExplorerBrowser.getGalaxyS7Capabilities
                        (InternetExplorerBrowser.getInternetExplorerOptions(internetExplorerOptions));
                break;
        }
    }

    public void setSafariPlatform(OperatorType operatorType, SafariOptions safariOptions) {
        switch (operatorType) {
            case MOBILE:
                safariOptions.setCapability("safari.mobile", "--window-size=300,450");
                break;
            case DESKTOP:
                safariOptions.setCapability("safari.mobile", "--window-size=1080,980");
                break;
            case IPHONE_6:
//                safariOptions.addArguments(BrowserUtility.getIphone6());
                break;
            case IPHONE_6_PLUS:
//                safariOptions.addArguments(BrowserUtility.getIphone6Plus());
                break;
            case IPHONE_8_PLUS:
//                safariOptions.addArguments(BrowserUtility.getIphone8Plus());
                break;
            case IPHONE_11:
//                safariOptions.addArguments(BrowserUtility.getIphone11());
                break;
            case IPAD:
//                safariOptions.addArguments(BrowserUtility.getIpad());
                break;
            case IPAD_LANDSCAPE:
//                safariOptions.addArguments(BrowserUtility.getIpadLandscape());
                break;
            case GALAXY_S7:
//                safariOptions.set(BrowserUtility.getGalaxyS7());
                break;
            default:
                LogImplementation.info("Unsupported OperatorType: " + operatorType);
                break;
        }
    }

}
