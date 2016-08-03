package com.instantcredit.commons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class AlphabetLoader {

    private static final String SEPARATOR = ",";
    private static final int LETTER_IDX = 0;
    private static final int TRANSLATION_IDX = 1;

    private static final Logger LOG = Logger.getLogger(AlphabetLoader.class.getName());
    private static final String ERROR_LOADING_ALPHABET = "An error occurred while loading the alphabet: ";

    public Map<String, String> getAlphabet() {

        Map<String, String> translationByAlphabetLetter = new HashMap<>();

        try {
            fillMap(translationByAlphabetLetter);
        } catch (IOException e) {
            LOG.warning(ERROR_LOADING_ALPHABET + e);
        }

        return translationByAlphabetLetter;
    }

    private void fillMap(Map<String, String> translationByAlphabetLetter) throws IOException {

        Path path = Paths.get(Constants.ALPHABET_PATH);

        Files.lines(path).forEach(line -> addLineToMap(translationByAlphabetLetter, line));
    }

    private void addLineToMap(Map<String, String> translationByAlphabetLetter, String line) {

        String[] splittedLine = line.split(SEPARATOR);
        translationByAlphabetLetter.put(splittedLine[LETTER_IDX], splittedLine[TRANSLATION_IDX]);
    }
}
