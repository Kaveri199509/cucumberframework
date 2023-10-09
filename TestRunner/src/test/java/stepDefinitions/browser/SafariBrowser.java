package stepDefinitions.browser;

import constants.Constants;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import stepDefinitions.enums.OperatorType;
import utility.ConfigFileReader;

import java.util.Map;

public class SafariBrowser {
    static ConfigFileReader configFileReader;

    private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static ThreadLocal<WebDriver> getDriver(OperatorType operatorType) {
        BrowserOptions<SafariOptions> options = new BrowserOptions<>(new SafariOptions());
        options.setSafariPlatform(operatorType, options.platform);
        tdriver.set(new SafariDriver(options.platform));
        return tdriver;
    }

    public static SafariOptions getSafariOptions(SafariOptions safariOptions) {
        setPlatformAttributes(safariOptions); //Browser version +platform name
        safariOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return safariOptions;
    }

    public static SafariOptions getiPhone6PlusCapabilities(SafariOptions safariOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 6 Plus");
        safariOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return safariOptions;
    }

    public static SafariOptions getiPhone6Capabilities(SafariOptions safariOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 6");
        safariOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return safariOptions;
    }

    public static SafariOptions getiPhone8PlusCapabilities(SafariOptions safariOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 8 Plus");
        safariOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return safariOptions;
    }

    public static SafariOptions getiPhone11Capabilities(SafariOptions safariOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(414, 896, 2.0);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPhone; CPU iPhone OS 13_3 like Mac OS X) AppleWebKit/605.1.15 "
                + "(KHTML, like Gecko) Version/13.0.4 Mobile/15E148 Safari/604.1");
        safariOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return safariOptions;
    }

    public static SafariOptions getiPadCapabilities(SafariOptions safariOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(768, 1024, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPad; CPU OS 11_0 like Mac OS X) AppleWebKit/604.1.34 "
                + "(KHTML, like Gecko) Version/11.0 Mobile/15A5341f Safari/604.1");
        safariOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return safariOptions;
    }

    public static SafariOptions getiPadLandscapeCapabilities(SafariOptions safariOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(1024, 768, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPad; CPU OS 11_2_6 like Mac OS X) AppleWebKit/604.5.6 "
                + "(KHTML, like Gecko) Version/11.0 Mobile/15D100 Safari/604.1");
        safariOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return safariOptions;
    }

    public static SafariOptions getGalaxyS7Capabilities(SafariOptions safariOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(360, 640, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (Linux; Android 7.0; SAMSUNG SM-G930F Build/MMB29K) AppleWebKit/537.36 (KHTML, like Gecko) "
                + "SamsungBrowser/4.0 Chrome/44.0.2403.133 Mobile Safari/537.36");
        safariOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return safariOptions;
    }

    public static void setPlatformAttributes(SafariOptions safariOptions) {
        safariOptions.setCapability(CapabilityType.BROWSER_VERSION, configFileReader.getBrowserVersion());
        safariOptions.setCapability(CapabilityType.PLATFORM_NAME, configFileReader.getPlatformName());
    }

}
