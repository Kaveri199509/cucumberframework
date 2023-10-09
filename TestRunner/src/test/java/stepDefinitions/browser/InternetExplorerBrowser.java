package stepDefinitions.browser;

import constants.Constants;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import stepDefinitions.enums.OperatorType;
import utility.ConfigFileReader;

import java.util.Map;

public class InternetExplorerBrowser {
    private static final ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    static WebDriver driver;
    static ConfigFileReader configFileReader;

    public static ThreadLocal<WebDriver> getDriver(OperatorType operatorType) {
        BrowserOptions<InternetExplorerOptions> options = new BrowserOptions<>(new InternetExplorerOptions());
        options.setInternetExplorerPlatform(operatorType, options.platform);
        tdriver.set(new InternetExplorerDriver(options.platform));
        return tdriver;
    }

    public static InternetExplorerOptions getInternetExplorerOptions(InternetExplorerOptions internetExplorerOptions) {
        setPlatformAttributes(internetExplorerOptions); //Browser version +platform name
//        setUnexpectedAlertBehaviour(internetExplorerOptions);
        internetExplorerOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

        return internetExplorerOptions;
    }

    public static InternetExplorerOptions getiPhone6PlusCapabilities(InternetExplorerOptions internetExplorerOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 6 Plus");
        internetExplorerOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);

        return internetExplorerOptions;
    }

    public static InternetExplorerOptions getiPhone6Capabilities(InternetExplorerOptions internetExplorerOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 6");
        internetExplorerOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return internetExplorerOptions;
    }

    public static InternetExplorerOptions getiPhone8PlusCapabilities(InternetExplorerOptions internetExplorerOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 8 Plus");
        internetExplorerOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return internetExplorerOptions;
    }

    public static InternetExplorerOptions getiPhone11Capabilities(InternetExplorerOptions internetExplorerOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(414, 896, 2.0);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPhone; CPU iPhone OS 13_3 like Mac OS X) AppleWebKit/605.1.15 "
                + "(KHTML, like Gecko) Version/13.0.4 Mobile/15E148 Safari/604.1");
        internetExplorerOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return internetExplorerOptions;
    }

    public static InternetExplorerOptions getiPadCapabilities(InternetExplorerOptions internetExplorerOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(768, 1024, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPad; CPU OS 11_0 like Mac OS X) AppleWebKit/604.1.34 "
                + "(KHTML, like Gecko) Version/11.0 Mobile/15A5341f Safari/604.1");
        internetExplorerOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return internetExplorerOptions;
    }

    public static InternetExplorerOptions getiPadLandscapeCapabilities(InternetExplorerOptions internetExplorerOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(1024, 768, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPad; CPU OS 11_2_6 like Mac OS X) AppleWebKit/604.5.6 "
                + "(KHTML, like Gecko) Version/11.0 Mobile/15D100 Safari/604.1");
        internetExplorerOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return internetExplorerOptions;
    }

    public static InternetExplorerOptions getGalaxyS7Capabilities(InternetExplorerOptions internetExplorerOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(360, 640, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (Linux; Android 7.0; SAMSUNG SM-G930F Build/MMB29K) AppleWebKit/537.36 (KHTML, like Gecko) "
                + "SamsungBrowser/4.0 Chrome/44.0.2403.133 Mobile Safari/537.36");
        internetExplorerOptions.setCapability(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return internetExplorerOptions;
    }

    public static void setPlatformAttributes(InternetExplorerOptions internetExplorerOptions) {
        internetExplorerOptions.setCapability(CapabilityType.BROWSER_VERSION, ConfigFileReader.getBrowserVersion());
        internetExplorerOptions.setCapability(CapabilityType.PLATFORM_NAME, ConfigFileReader.getPlatformName());
    }


}
