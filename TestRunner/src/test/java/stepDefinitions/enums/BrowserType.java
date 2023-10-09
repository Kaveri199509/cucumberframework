package stepDefinitions.enums;

public enum BrowserType {
    CHROME("Chrome"),
    FIREFOX("FireFox"),
    INTERNET_EXPLORER("InternetExplorer"),
    EDGE("Edge"),
    SAFARI("Safari");
    private final String type;

    BrowserType(final String type){
        this.type=type;
    }
}
