package stepDefinitions.browser;

import constants.Constants;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import stepDefinitions.enums.OperatorType;
import utility.ConfigFileReader;

import java.util.Map;

public class ChromeBrowser {

    private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    static ConfigFileReader configFileReader;

    public static ThreadLocal<WebDriver> getDriver(OperatorType operatorType) {
        BrowserOptions<ChromeOptions> options = new BrowserOptions<>(new ChromeOptions());
        options.setChromePlatform(operatorType, options.platform);
        tdriver.set(new ChromeDriver(options.platform));
        System.out.println("tdriver = " + tdriver);
        return tdriver;
    }

    public static ChromeOptions getChromeOptions(ChromeOptions chromeOptions) {
        setPlatformAttributes(chromeOptions); //Browser version +platform name
//        setUnexpectedAlertBehaviour(chromeOptions);
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return chromeOptions;
    }

    public static ChromeOptions getiPhone6PlusCapabilities(ChromeOptions chromeOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 6 Plus");
        chromeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return chromeOptions;
    }

    public static ChromeOptions getiPhone6Capabilities(ChromeOptions chromeOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 6");
        chromeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return chromeOptions;
    }

    public static ChromeOptions getiPhone8PlusCapabilities(ChromeOptions chromeOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 8 Plus");
        chromeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return chromeOptions;
    }

    public static ChromeOptions getiPhone11Capabilities(ChromeOptions chromeOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(414, 896, 2.0);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPhone; CPU iPhone OS 13_3 like Mac OS X) AppleWebKit/605.1.15 "
                + "(KHTML, like Gecko) Version/13.0.4 Mobile/15E148 Safari/604.1");
        chromeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);

        return chromeOptions;
    }

    public static ChromeOptions getiPadCapabilities(ChromeOptions chromeOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(768, 1024, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPad; CPU OS 11_0 like Mac OS X) AppleWebKit/604.1.34 "
                + "(KHTML, like Gecko) Version/11.0 Mobile/15A5341f Safari/604.1");
        chromeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return chromeOptions;
    }

    public static ChromeOptions getiPadLandscapeCapabilities(ChromeOptions chromeOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(1024, 768, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPad; CPU OS 11_2_6 like Mac OS X) AppleWebKit/604.5.6 "
                + "(KHTML, like Gecko) Version/11.0 Mobile/15D100 Safari/604.1");
        chromeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return chromeOptions;
    }

    public static ChromeOptions getGalaxyS7Capabilities(ChromeOptions chromeOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(360, 640, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (Linux; Android 7.0; SAMSUNG SM-G930F Build/MMB29K) AppleWebKit/537.36 (KHTML, like Gecko) "
                + "SamsungBrowser/4.0 Chrome/44.0.2403.133 Mobile Safari/537.36");
        chromeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return chromeOptions;
    }

    public static void setPlatformAttributes(ChromeOptions chromeOptions) {
        chromeOptions.setCapability(CapabilityType.BROWSER_VERSION, configFileReader.getBrowserVersion());
        chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, configFileReader.getPlatformName());
    }

}
