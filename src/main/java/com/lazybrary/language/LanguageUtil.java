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
        List<String> result = new ArrayList<>();

        for (int i = 0; i < target.length(); i++) {
            char currentChar = target.charAt(i);

            if (currentChar >= KoreanAlphabet.KOREAN_UNI) {
                int adjustedCode = currentChar - KoreanAlphabet.KOREAN_UNI;
                char choSung = (char) (adjustedCode / 28 / 21);
                char joongSung = (char) ((adjustedCode / 28) % 21);
                char jongSung = (char) (adjustedCode % 28);

                result.add(KoreanAlphabet.VAL1[choSung]); // CHO-SUNG aka 초성
                result.add(KoreanAlphabet.VAL2[joongSung]); // JOONG-SUNG aka 중성
                result.add(KoreanAlphabet.VAL3[jongSung]); // JONG-SUNG aka 종성, it can be empty
            } else {
                result.add(Character.toString(currentChar));
            }
        }

        return result.toArray(new String[0]);
    }
}
