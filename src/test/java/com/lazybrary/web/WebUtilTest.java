package com.lazybrary.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebUtilTest {

    @Test
    void generateRandomPasswordTest() {
        String pswd = WebUtil.generateRandomPassword(12);
        Assertions.assertNotNull(pswd);
    }
}