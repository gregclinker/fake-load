package com.essexboy;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        if (System.getenv("MEM_TO_USE_MI") == null) {
            System.out.println("ERROR MEM_TO_USE_MI Env is null");
        }
        if (System.getenv("THREADS_TO_RUN") == null) {
            System.out.println("ERROR THREADS_TO_RUN Env is null");
        }
        try {
            System.out.println("using THREADS_TO_RUN=" + System.getenv("THREADS_TO_RUN") + ", MEM_TO_USE_MI=" + System.getenv("MEM_TO_USE_MI"));
            final int memToUseMi = Integer.parseInt(System.getenv("MEM_TO_USE_MI"));
            final int threadsToRun = Integer.parseInt(System.getenv("THREADS_TO_RUN"));
            new FakeLoad(memToUseMi, threadsToRun);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
