package stepDefinitions.browser;

import constants.Constants;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import stepDefinitions.enums.OperatorType;
import utility.ConfigFileReader;

import java.util.Map;

public class EdgeBrowser {
    static WebDriver driver;
    static ConfigFileReader configFileReader;

    private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static ThreadLocal<WebDriver> getDriver(OperatorType operatorType) {
        BrowserOptions<EdgeOptions> options = new BrowserOptions<>(new EdgeOptions());
        options.setEdgePlatform(operatorType, options.platform);
        tdriver.set(new EdgeDriver(options.platform));
        return tdriver;
    }

    public static EdgeOptions getEdgeOptions(EdgeOptions edgeOptions) {
        setPlatformAttributes(edgeOptions); //Browser version +platform name
//        setUnexpectedAlertBehaviour(edgeOptions);
        edgeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return edgeOptions;
    }

    public static EdgeOptions getiPhone6PlusCapabilities(EdgeOptions edgeOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 6 Plus");
        edgeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return edgeOptions;
    }

    public static EdgeOptions getiPhone6Capabilities(EdgeOptions edgeOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 6");
        edgeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return edgeOptions;
    }

    public static EdgeOptions getiPhone8PlusCapabilities(EdgeOptions edgeOptions) {
        Map<String, String> mobileEmulation = BrowserUtility.setEmulator("iPhone 8 Plus");
        edgeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return edgeOptions;
    }

    public static EdgeOptions getiPhone11Capabilities(EdgeOptions edgeOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(414, 896, 2.0);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPhone; CPU iPhone OS 13_3 like Mac OS X) AppleWebKit/605.1.15 "
                + "(KHTML, like Gecko) Version/13.0.4 Mobile/15E148 Safari/604.1");
        edgeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return edgeOptions;
    }

    public static EdgeOptions getiPadCapabilities(EdgeOptions edgeOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(768, 1024, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPad; CPU OS 11_0 like Mac OS X) AppleWebKit/604.1.34 "
                + "(KHTML, like Gecko) Version/11.0 Mobile/15A5341f Safari/604.1");
        edgeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return edgeOptions;
    }

    public static EdgeOptions getiPadLandscapeCapabilities(EdgeOptions edgeOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(1024, 768, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (iPad; CPU OS 11_2_6 like Mac OS X) AppleWebKit/604.5.6 "
                + "(KHTML, like Gecko) Version/11.0 Mobile/15D100 Safari/604.1");
        edgeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return edgeOptions;
    }

    public static EdgeOptions getGalaxyS7Capabilities(EdgeOptions edgeOptions) {
        Map<String, Object> deviceMetrics = BrowserUtility.setDeviceMetrics(360, 640, 1);
        Map<String, Object> mobileEmulation = BrowserUtility.setEmulator(deviceMetrics, "Mozilla/5.0 (Linux; Android 7.0; SAMSUNG SM-G930F Build/MMB29K) AppleWebKit/537.36 (KHTML, like Gecko) "
                + "SamsungBrowser/4.0 Chrome/44.0.2403.133 Mobile Safari/537.36");
        edgeOptions.setExperimentalOption(Constants.MOBILE_EMULATION_CAPABILITY, mobileEmulation);
        return edgeOptions;
    }

    public static void setPlatformAttributes(EdgeOptions edgeOptions) {
        edgeOptions.setCapability(CapabilityType.BROWSER_VERSION, configFileReader.getBrowserVersion());
        edgeOptions.setCapability(CapabilityType.PLATFORM_NAME, configFileReader.getPlatformName());
    }

}
