package com.lazybrary.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void isNullOrEmpty() {
        String notNullString = "hello";
        String notEmptyString = " ";
        String nullString = null;
        String emptyString = "";

        Assertions.assertFalse(StringUtil.isNullOrEmpty(notNullString));
        Assertions.assertFalse(StringUtil.isNullOrEmpty(notEmptyString));
        Assertions.assertTrue(StringUtil.isNullOrEmpty(nullString));
        Assertions.assertTrue(StringUtil.isNullOrEmpty(emptyString));
    }

    @Test
    void commaTest(){
        String comma = StringUtil.comma(232220111);
        Assertions.assertEquals("232,220,111", comma);
    }
}