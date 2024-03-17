package com.essexboy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class FakeLoad implements Runnable {

    final static Logger LOGGER = LoggerFactory.getLogger(FakeLoad.class);
    private int randomStringLength;

    private int threadsToUse;

    private List<List<byte[]>> byteLists = new ArrayList<>();

    public FakeLoad(int randomStringLength, int threadsToUse) {
        this.randomStringLength = randomStringLength;
        this.threadsToUse = threadsToUse;
        for (int i = 0; i < randomStringLength; i++) {
            final int size = 1024 * 1024;
            //byteLists.add(Arrays.asList(new byte[size]));
        }
        //LOGGER.debug("created {} Mi of fake memory", memToUseMi);
        for (int i = 0; i < threadsToUse; i++) {
            new Thread(this).start();
        }
    }

    @Override
    public void run() {
        LOGGER.debug("started dummy load thread with random strings of legth " + randomStringLength);
        List list = new ArrayList<String>();
        for (int i = 0; i < 100000; i++) {
            list.add(randomString(randomStringLength));
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
