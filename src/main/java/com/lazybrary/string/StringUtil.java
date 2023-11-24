package com.lazybrary.string;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static DecimalFormat decimalFormatInStringUtil;
    /**
     * Check String that is it null or empty (for java 8 only, )
     * @param val
     * @return
     */
    public static boolean isNullOrEmpty(String val){
        return val == null || val.length() == 0;
    }

    public static String comma(Number number){
        decimalFormatInStringUtil = new DecimalFormat("###,###");
        return decimalFormatInStringUtil.format(number);
    }

    public static boolean isMatched(String regex, String target){
        if (regex == null || target == null) {
            throw new NullPointerException("Regex and target must not be null");
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);
        return matcher.find();
    }
}
