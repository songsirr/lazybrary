package com.lazybrary.string;

public class StringUtil {

    /**
     * Check String that is it null or empty (for java 8 only, )
     * @param val
     * @return
     */
    public static boolean isNullOrEmpty(String val){
        return val == null || val.length() == 0;
    }
}
