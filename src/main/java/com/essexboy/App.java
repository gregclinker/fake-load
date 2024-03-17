package com.essexboy;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        if (System.getenv("RANDOM_STRING_LENGTH") == null) {
            System.out.println("ERROR RANDOM_STRING_LENGTH Env is null");
        }
        if (System.getenv("THREADS_TO_RUN") == null) {
            System.out.println("ERROR THREADS_TO_RUN Env is null");
        }
        try {
            System.out.println("using THREADS_TO_RUN=" + System.getenv("THREADS_TO_RUN") + ", RANDOM_STRING_LENGTH=" + System.getenv("RANDOM_STRING_LENGTH"));
            final int randomStringLength = Integer.parseInt(System.getenv("RANDOM_STRING_LENGTH"));
            final int threadsToRun = Integer.parseInt(System.getenv("THREADS_TO_RUN"));
            new FakeLoad(randomStringLength, threadsToRun);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
