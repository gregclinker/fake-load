package com.essexboy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void test1() {
        assertTrue(true);
        List list = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }

        byte[] bytes = new byte[1000*1000*1000]; // use 1 MB of memory.

        final long start = System.currentTimeMillis();
        Collections.shuffle(list);
        Collections.sort(list);
        System.out.println(System.currentTimeMillis() - start);
    }
}