package com.lazybrary.date;

import com.lazybrary.date.constant.DateConstant;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

    public static String formatAs(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String formatAs(ZonedDateTime zdt, String format) {
        return zdt.format(DateTimeFormatter.ofPattern(format));
    }

    public static String formatAs(OffsetDateTime odt, String format) {
        return odt.format(DateTimeFormatter.ofPattern(format));
    }

    public static ZonedDateTime changeZone(ZonedDateTime org, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(org.toInstant(), zoneId);
    }

    public static String changeZoneOfISOString(String iso8601String, String format, ZoneId zoneId) {
        if (zoneId == null) {
            zoneId = getZoneIdFromIso8601String(iso8601String);
        }
        ZonedDateTime zdt = ZonedDateTime.parse(iso8601String, DateTimeFormatter.ofPattern(format));
        return zdt.withZoneSameInstant(zoneId).format(DateTimeFormatter.ofPattern(format));
    }

    public static ZoneId getZoneIdFromIso8601String(String iso8601String) {
        Pattern pattern = Pattern.compile(DateConstant.REGEX_FOR_OFFSET);
        Matcher matcher = pattern.matcher(iso8601String);

        if (matcher.find()) {
            return ZoneId.of(matcher.group(1));
        } else {
            throw new IllegalArgumentException("Invalid ISO 8601 string: " + iso8601String);
        }
    }
}
