package com.essexboy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void test1() {
        assertTrue(true);
        List list = new ArrayList<String>();
        for (int i = 0; i < 10000000; i++) {
            list.add(randomString(10));
        }

        byte[] bytes = new byte[1000 * 1000 * 1000]; // use 1 MB of memory.

        final long start = System.currentTimeMillis();
        Collections.shuffle(list);
        Collections.sort(list);
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void randomString() {
        final String generatedString = randomString(100);
        System.out.println(generatedString);
    }

    private String randomString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}