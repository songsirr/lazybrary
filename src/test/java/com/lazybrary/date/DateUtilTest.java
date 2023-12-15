package com.lazybrary.date;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.Date;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateUtilTest {

    private static final String ISO8601_OFFSET = "yyyy-MM-dd'T'HH:mm:ssXXX";

    @Test
    void testChangeZoneOfISOString() {
        String iso8601String = "2023-01-01T12:34:56+03:00";
        ZoneId targetZone = ZoneId.of("America/New_York");
        String result = DateUtil.changeZoneOfISOString(iso8601String, ISO8601_OFFSET, targetZone);

        // You might want to assert the result more precisely
        assertEquals("2023-01-01T04:34:56-05:00", result);
    }

    @Test
    void testGetZoneIdFromIso8601String() {
        String iso8601String = "2023-01-01T12:34:56+03:00";
        ZoneId zoneId = DateUtil.getZoneIdFromIso8601String(iso8601String);

        assertEquals(ZoneId.of("+03:00"), zoneId);
    }

    @Test
    void testGetZoneIdFromInvalidIso8601String() {
        String invalidIso8601String = "invalid";
        assertThrows(IllegalArgumentException.class, () -> DateUtil.getZoneIdFromIso8601String(invalidIso8601String));
    }
}