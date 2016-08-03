package com.instantcredit.service;

import com.instantcredit.commons.Alphabet;

public class CipherService {

    public String encrypt(String text) throws Throwable {
        Translator t = new PlainTextTranslator(Alphabet.getInstance().getAlphabet());
        return t.translate(text);
    }

}
