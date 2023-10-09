package stepDefinitions.browser;

import constants.Constants;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import stepDefinitions.enums.OperatorType;
import utility.ConfigFileReader;

import java.util.Map;


public class FireFoxBrowser {
    private static final ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    static WebDriver driver;
    static ConfigFileReader configFileReader;

    public static ThreadLocal<WebDriver> getDriver(OperatorType operatorType) {
        BrowserOptions<FirefoxOptions> options = new BrowserOptions<>(new FirefoxOptions());
        options.setFireFoxPlatform(operatorType, options.platform);
        tdriver.set(new FirefoxDriver(options.platform));
        return tdriver;
    }

    public static FirefoxOptions getFirefoxOptions(FirefoxOptions firefoxOptions) {
        setPlatformAttributes(firefoxOptions); //Browser version +platform name
//        setUnexpectedAlertBehaviour(firefoxOptions);
        firefoxOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

        return firefoxOptions;
    }

    public static FirefoxOptions getiPhone6PlusCapabilities(FirefoxOptions firefoxOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 6 Plus");
        firefoxOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return firefoxOptions;
    }

    public static FirefoxOptions getiPhone6Capabilities(FirefoxOptions firefoxOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 6");
        firefoxOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return firefoxOptions;
    }

    public static FirefoxOptions getiPhone8PlusCapabilities(FirefoxOptions firefoxOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 8 Plus");
        firefoxOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return firefoxOptions;
    }

    public static FirefoxOptions getiPhone11Capabilities(FirefoxOptions firefoxOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(414, 896, 2.0);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPhone; CPU iPhone OS 13_3 like Mac OS X) AppleWebKit/605.1.15 "
                + "(KHTML, like Gecko) Version/13.0.4 Mobile/15E148 Safari/604.1");
        firefoxOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return firefoxOptions;
    }

    public static FirefoxOptions getiPadCapabilities(FirefoxOptions firefoxOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(768, 1024, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPad; CPU OS 11_0 like Mac OS X) AppleWebKit/604.1.34 "
                + "(KHTML, like Gecko) Version/11.0 Mobile/15A5341f Safari/604.1");
        firefoxOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return firefoxOptions;
    }

    public static FirefoxOptions getiPadLandscapeCapabilities(FirefoxOptions firefoxOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(1024, 768, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPad; CPU OS 11_2_6 like Mac OS X) AppleWebKit/604.5.6 "
                + "(KHTML, like Gecko) Version/11.0 Mobile/15D100 Safari/604.1");
        firefoxOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return firefoxOptions;
    }

    public static FirefoxOptions getGalaxyS7Capabilities(FirefoxOptions firefoxOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(360, 640, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (Linux; Android 7.0; SAMSUNG SM-G930F Build/MMB29K) AppleWebKit/537.36 (KHTML, like Gecko) "
                + "SamsungBrowser/4.0 Chrome/44.0.2403.133 Mobile Safari/537.36");
        firefoxOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return firefoxOptions;
    }

    public static void setPlatformAttributes(FirefoxOptions firefoxOptions) {
        firefoxOptions.setCapability(CapabilityType.BROWSER_VERSION, ConfigFileReader.getBrowserVersion());
        firefoxOptions.setCapability(CapabilityType.PLATFORM_NAME, ConfigFileReader.getPlatformName());
    }

}
