package com.instantcredit.commons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VocabularyLoader {

    public static final String ERROR_LOADING_VOCABULARY = "An error occurred while loading the vocabulary: ";
    private static final Logger LOG = Logger.getLogger(VocabularyLoader.class.getName());

    public List<String> getVocabulary() {

        List<String> vocabulary_list = new ArrayList<>();
        Path path = Paths.get(Constants.VOCABULARY_PATH);

        try (Stream<String> lines = Files.lines(path)) {
            vocabulary_list = lines.collect(Collectors.toList());
        } catch (IOException e) {
            LOG.warning(ERROR_LOADING_VOCABULARY + e);
        }
        sortAlphabetically(vocabulary_list);
        return vocabulary_list;
    }

    private void sortAlphabetically(List<String> vocabulary_list) {
        Collections.sort(vocabulary_list, ALPHABETICAL_ORDER);
    }

    private static Comparator<String> ALPHABETICAL_ORDER = (str1, str2) -> {
        int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
        return (res != 0) ? res : str1.compareTo(str2);
    };
}
