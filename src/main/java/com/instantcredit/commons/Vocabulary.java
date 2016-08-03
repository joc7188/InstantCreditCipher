package com.instantcredit.commons;

import java.util.List;


public class Vocabulary {

    private static Vocabulary INSTANCE;

    private List<String> vocabulary_list;


    private Vocabulary() {
        VocabularyLoader vl = new VocabularyLoader();
        vocabulary_list = vl.getVocabulary();
    }

    public static Vocabulary getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Vocabulary();
        }
        return INSTANCE;
    }


    public List<String> getVocabulary_list() {
        return vocabulary_list;
    }

}
