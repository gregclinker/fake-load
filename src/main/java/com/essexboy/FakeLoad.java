package com.essexboy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FakeLoad implements Runnable {

    final static Logger LOGGER = LoggerFactory.getLogger(FakeLoad.class);

    private int memToUseMi;
    private int threadsToUse;

    private List<List<byte[]>> byteLists = new ArrayList<>();

    public FakeLoad(int memToUseMi, int threadsToUse) {
        this.memToUseMi = memToUseMi;
        this.threadsToUse = threadsToUse;
        for (int i = 0; i < memToUseMi; i++) {
            final int size = 1024 * 1024;
            byteLists.add(Arrays.asList(new byte[size]));
        }
        LOGGER.debug("created {} Mi of fake memory", memToUseMi);
        for (int i = 0; i < threadsToUse; i++) {
            new Thread(this).start();
        }
    }

    @Override
    public void run() {
        LOGGER.debug("started dummy load thread");
        List list = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        while (true) {
            Collections.shuffle(list);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Collections.sort(list);
        }
    }
}
