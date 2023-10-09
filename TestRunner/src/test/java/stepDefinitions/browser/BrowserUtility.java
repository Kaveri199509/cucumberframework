package stepDefinitions.browser;

import constants.Constants;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserUtility {
    static WebDriver driver;

    public static Map<String, String> setEmulator(String deviceName) {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put(Constants.DEVICE_NAME_CAPABILITY, deviceName);
        return mobileEmulation;
    }

    public static Map<String, Object> setEmulator(Map<String, Object> deviceMetrics,String userAgent) {
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put(Constants.DEVICE_METRICS,deviceMetrics);
        mobileEmulation.put(Constants.USER_AGENT,userAgent);
        return mobileEmulation;
    }

    public static Map<String, Object> setDeviceMetrics(int width,int height,double pixelRatio ) {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put(Constants.WIDTH, width);
        deviceMetrics.put(Constants.HEIGHT, height);
        deviceMetrics.put(Constants.PIXEL_RATIO,pixelRatio);
        return deviceMetrics;
    }

    public static String getMobileResoultion() {
        return "--window-size=300,450";
    }



    public static String getIphone6(){
        return "--window-size=390,800";
    }

    public static String getIphone6Plus(){
        return "--window-size=400,850";
    }

    public static String getIphone8Plus(){
        return "--window-size=375,825";
    }

    public static String getIphone11() {
        return "--window-size=414,896";
    }
    public static String getIpad(){
        return "--window-size=768,1024";
    }

    public static String getIphoneLandscape(){
        return "--window-size=1024,768";
    }

    public static String getGalaxyS7(){
        return "--window-size=360,640";
    }

    public static String getDesktopResoultion() {
        return "--start-maximized";
    }
}