package stepDefinitions.enums;

public enum OperatorType {

    ALL_MOBILE("AllMobile"),
    MOBILE("Mobile"),
    DESKTOP("Desktop"),
    IPHONE_6("Iphone_6"),
    IPHONE_6_PLUS("Iphone_6_Plus"),
    IPHONE_8_PLUS("Iphone_8_Plus"),
    IPHONE_11("Iphone_11"),
    IPAD("Ipad"),
    IPAD_LANDSCAPE("Ipad_Landscape"),
    GALAXY_S7("Galaxy_S7");

    private final String operatorType;


    OperatorType(final String operatorType){
        this.operatorType=operatorType;
    }
}
