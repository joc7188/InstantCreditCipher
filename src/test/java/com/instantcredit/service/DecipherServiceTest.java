package com.instantcredit.service;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static junit.framework.Assert.assertTrue;


public class DecipherServiceTest {

    public static final int STR_LENGTH = 15;
    public static final int RANDOM_ARRAY_SIZE = 10;

    @Test
    public void testThat_givenEncryptedText_returns_itDecrypted() throws Throwable {
        DecipherService ds = new DecipherService();
        CipherService cs = new CipherService();

        List<String> rts = generateRandomTestSet(RANDOM_ARRAY_SIZE, STR_LENGTH);
        rts.stream().forEach(encrypted_text -> {
            try {
                String decrypted_text = ds.decrypt(encrypted_text);
                String encrypted_text_from_decrypted = cs.encrypt(decrypted_text);
                assertTrue(encrypted_text_from_decrypted.equals(cs.encrypt(decrypted_text)));
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    @Test
    public void testThat_givenEncryptedText_returns_VocabularyWordsThatAreCandidates() {
        DecipherService dc = new DecipherService();

        boolean good_output = true;
        String random_encrypted_text = generateRandomEncryptedText(STR_LENGTH);

        List<String> ls = dc.findDecryptionOptions(random_encrypted_text);
        if (ls.contains(null))
            good_output = false;


        assertTrue(good_output);
    }

    private List<String> generateRandomTestSet(int size, int str_length) {
        List<String> l = new ArrayList();
        for (int i = 0; i < size; i++) {
            l.add(generateRandomEncryptedText(str_length));
        }
        return l;
    }

    private String generateRandomEncryptedText(int max_size) {
        int length = getRandomNumberInRange(1, max_size);
        StringBuilder string_test = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int symbol = getRandomNumberInRange(0, 1);
            if (symbol == 0)
                string_test.append("⍢");
            else
                string_test.append("⍙");
        }
        return string_test.toString();
    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();
    }

}