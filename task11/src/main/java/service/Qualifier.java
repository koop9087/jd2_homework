package service;

public class Qualifier {
    public static final String PATTERN_FOR_OPERA ="OPR/";
    public static final String PATTERN_FOR_EDGE ="Edg/";
    public static final String PATTERN_FOR_SAFARI = "Mobile";
    public static final String PATTERN_FOR_EXPLORER = "IEMobile";
    public static final String PATTERN_FOR_FIREFOX = "Firefox/";

    public static String parseBrName(String line){
        String brName = "chrome";
        if(line.contains(PATTERN_FOR_EDGE)) {
            brName = "edge";
        } else if (line.contains(PATTERN_FOR_EXPLORER)) {
            brName = "explorer";
        } else if (line.contains(PATTERN_FOR_SAFARI)) {
            brName = "safari";
        } else if (line.contains(PATTERN_FOR_OPERA)) {
            brName = "opera";
        } else if (line.contains(PATTERN_FOR_FIREFOX)) {
            brName = "firefox";
        }
        return brName;
    }
}
