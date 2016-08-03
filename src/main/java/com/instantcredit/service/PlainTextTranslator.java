package com.instantcredit.service;

import java.util.Map;

public class PlainTextTranslator implements Translator {

    private Map<String, String> alphabet;

    public PlainTextTranslator(Map<String, String> alphabet) {
        this.alphabet = alphabet;
    }


    @Override
    public String translate(String text) {
        String translation = "";
        for (char c : text.toCharArray()) {
            translation += alphabet.get(Character.toString(Character.toUpperCase(c)));
        }
        return translation;
    }
}
