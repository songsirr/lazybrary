package com.lazybrary.string;

import java.text.DecimalFormat;

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
}
