package com.lazybrary.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String ISO8601_DEFAULT = "yyyy-MM-dd'T'HH:mm:ss";

    public static final String ISO8601_OFFSET = "yyyy-MM-dd'T'HH:mm:ssZ";

    public static String asString(Date date, String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String asISO8601(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ISO8601_DEFAULT);
        return simpleDateFormat.format(date);
    }

    public static String asISO8601WithOffset(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ISO8601_OFFSET);
        return simpleDateFormat.format(date);
    }
}
