package com.instantcredit.service;

import com.instantcredit.commons.Alphabet;
import com.instantcredit.commons.Vocabulary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DecipherService {

    private Map<String, String> alphabet;
    private List<String> vocabulary;
    Translator textTranslator;

    public DecipherService() {
        alphabet = Alphabet.getInstance().getAlphabet();

        vocabulary = Vocabulary.getInstance().getVocabulary_list();

        textTranslator = new PlainTextTranslator(alphabet);

    }

    public String decrypt(String text) {

        return recursiveDecrypt(text);
    }

    private String recursiveDecrypt(String text) {
        boolean found = false;
        List<String> options = findDecryptionOptions(text);
        int i = 0;
        String decrypted_text = "";
        while (!found && i < options.size()) {
            decrypted_text = recursiveDecrypt(text.replaceFirst(textTranslator.translate(options.get(i)), ""));
            if (!decrypted_text.equals("-1"))
                found = true;
            else
                i++;
        }
        if (found)
            return options.get(i).concat(decrypted_text);
        else if (options.isEmpty() && text.isEmpty())
            return "";
        else
            return "-1";
    }


    public List<String> findDecryptionOptions(String text_to_decrypt) {
        List<String> options = new ArrayList();
        vocabulary.parallelStream().forEach(word -> {
                    String translate = textTranslator.translate(word);
                    if (text_to_decrypt.startsWith(translate)) {
                        options.add(word);
                    }
                }
        );
        options.removeAll(Collections.singleton(null));
        return options;
    }

    //Todo: Method that returns a list of all possible decryption options
    public List<String> decryptAllOptions(String text) {
        List<String> all_options_decrypted = new ArrayList();
        List<String> options = findDecryptionOptions(text);
        for (String item : options) {
            //all_options_decrypted.add(item.concat(decryptAllOptions(text.replaceFirst(textTranslator.translate(item), ""))));
        }
        return all_options_decrypted;
    }


}
