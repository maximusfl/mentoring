package org.example;

public class SynchronizeExample {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        long before = System.currentTimeMillis();
        new SynchronizeExample().doWork();
        long after = System.currentTimeMillis();
        System.out.println("Program took " + (after - before) + " ms");
    }

    public void increment() {
        synchronized (this) {
            counter = counter + 1;
        }
    }

    public void doWork() throws InterruptedException {


        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });
        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(counter);

    }
}
