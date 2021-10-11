package service;

public class Qualifier {
    public static final String PATTERN_FOR_OPERA ="OPR/";
    public static final String PATTERN_FOR_EDGE ="Edg/";
    public static final String PATTERN_FOR_SAFARI = "Mobile";
    public static final String PATTERN_FOR_EXPLORER = "IEMobile";
    public static final String PATTERN_FOR_FIREFOX = "Firefox/";
    public static final String CHROME = "chrome";
    public static final String EDGE = "edge";
    public static final String EXPLORER = "explorer";
    public static final String SAFARI = "safari";
    public static final String OPERA = "opera";
    public static final String FIREFOX = "firefox";

    public static String parseBrName(String line){
        String brName = CHROME;
        if(line.contains(PATTERN_FOR_EDGE)) {
            brName = EDGE;
        } else if (line.contains(PATTERN_FOR_EXPLORER)) {
            brName = EXPLORER;
        } else if (line.contains(PATTERN_FOR_SAFARI)) {
            brName = SAFARI;
        } else if (line.contains(PATTERN_FOR_OPERA)) {
            brName = OPERA;
        } else if (line.contains(PATTERN_FOR_FIREFOX)) {
            brName = FIREFOX;
        }
        return brName;
    }
}
