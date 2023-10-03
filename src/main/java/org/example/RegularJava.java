package org.example;

import java.util.regex.Pattern;

public class RegularJava {

    private static String patternIP = "(((25[0-5]|2[0-4]\\d|[01]?\\d{1,2})\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d{1,2}))";
    public boolean correctIP(String ip){
        return Pattern.matches(patternIP, ip);
    }

    private static String patternGuid = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}";
    public boolean correctGuid(String guid){
        return Pattern.matches(patternGuid, guid);
    }

    private static String patternURL = "^(https?:\\/\\/)?(?!www\\.)([\\da-z\\.]{2,})\\.([a-z\\.]{2,6})([\\/\\w\\S \\.-]*)*\\/?$";
    public boolean correctURL(String url){
        return Pattern.matches(patternURL, url);
    }

    private static String patternPassword = "^(?=.+[A-Z])(?=.+[a-z])(?=.+[0-9])[\\S]{8,}$";

    public boolean strongPassword(String pass) {
        return Pattern.matches(patternPassword, pass);
    }

}