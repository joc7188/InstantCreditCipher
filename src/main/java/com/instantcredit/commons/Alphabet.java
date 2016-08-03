package com.instantcredit.commons;


import java.util.Map;

public class Alphabet {
    private static Alphabet INSTANCE;
    private Map<String, String> alphabet;


    private Alphabet() {
        AlphabetLoader al = new AlphabetLoader();
        alphabet = al.getAlphabet();
    }

    public static Alphabet getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Alphabet();
        }
        return INSTANCE;
    }

    public Map<String, String> getAlphabet() {
        return alphabet;
    }
}
