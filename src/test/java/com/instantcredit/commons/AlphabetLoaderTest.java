package com.instantcredit.commons;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AlphabetLoaderTest {

    @Test
    public void testThat_givenAlphabetFile_returnsTranslations() {

        AlphabetLoader alphabetLoader = new AlphabetLoader();

        Map<String, String> alphabet = alphabetLoader.getAlphabet();

        assertTrue(alphabet.keySet().size() == 26);

        assertTrue(alphabet.get("A").equals("⍢⍙"));
        assertTrue(alphabet.get("B").equals("⍙⍢⍢⍢"));
        assertTrue(alphabet.get("C").equals("⍙⍢⍙⍢"));
        assertTrue(alphabet.get("D").equals("⍙⍢⍢"));
        assertTrue(alphabet.get("E").equals("⍢"));
        assertTrue(alphabet.get("F").equals("⍢⍢⍙⍢"));
        assertTrue(alphabet.get("G").equals("⍙⍙⍢"));
        assertTrue(alphabet.get("H").equals("⍢⍢⍢⍢"));
        assertTrue(alphabet.get("I").equals("⍢⍢"));
        assertTrue(alphabet.get("J").equals("⍢⍙⍙⍙"));
        assertTrue(alphabet.get("K").equals("⍙⍢⍙"));
        assertTrue(alphabet.get("L").equals("⍢⍙⍢⍢"));
        assertTrue(alphabet.get("M").equals("⍙⍙"));
        assertTrue(alphabet.get("N").equals("⍙⍢"));
        assertTrue(alphabet.get("O").equals("⍙⍙⍙"));
        assertTrue(alphabet.get("P").equals("⍢⍙⍙⍢"));
        assertTrue(alphabet.get("Q").equals("⍙⍙⍢⍙"));
        assertTrue(alphabet.get("R").equals("⍢⍙⍢"));
        assertTrue(alphabet.get("S").equals("⍢⍢⍢"));
        assertTrue(alphabet.get("T").equals("⍙"));
        assertTrue(alphabet.get("U").equals("⍢⍢⍙"));
        assertTrue(alphabet.get("V").equals("⍢⍢⍢⍙"));
        assertTrue(alphabet.get("W").equals("⍢⍙⍙"));
        assertTrue(alphabet.get("X").equals("⍙⍢⍢⍙"));
        assertTrue(alphabet.get("Y").equals("⍙⍢⍙⍙"));
        assertTrue(alphabet.get("Z").equals("⍙⍙⍢⍢"));

    }
}
