package com.lazybrary.language;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanguageUtilTest {

    @Test
    void koreanSplitter(){
        String s = "안녕하세요 이 메서드는 한글을 분해해 줍니다.";
        String[] arr = LanguageUtil.koreanSplitter(s);
        for (String character : arr) {
            System.out.println(character);
        }
    }
}