package com.lazybrary.language;

import com.lazybrary.language.korean.KoreanAlphabet;

import java.util.ArrayList;
import java.util.List;

public class LanguageUtil {

    /**
     * split Korean sentence or word into Hangul Jamo
     * you can refer about Hangul from
     * <a href="https://en.wikipedia.org/wiki/Hangul_Jamo_(Unicode_block)">...</a>
     * @param target The sentence or word you want to separate
     * @return String array composed of Hangul Jamo
     */
    public static String[] koreanSplitter(String target){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < target.length(); i++){
            char c = target.charAt(i);
            if (c >= KoreanAlphabet.KOREAN_UNI){
                c = (char)(c - KoreanAlphabet.KOREAN_UNI);
                char val1 = (char)(c/28/21);
                char val2 = (char)((c)/28%21);
                char val3 = (char)(c%28);
                list.add(KoreanAlphabet.VAL1[val1]); // CHO-SUNG aka 초성
                list.add(KoreanAlphabet.VAL2[val2]); // JOONG-SUNG aka 중성
                list.add(KoreanAlphabet.VAL3[val3]); // JONG-SUNG aka 종성, it can be empty
            } else {
                list.add(Character.toString(c));
            }
        }
        return list.toArray(list.toArray(new String[0]));
    }
}
