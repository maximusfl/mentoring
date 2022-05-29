package org.example;

public class VolatileExample {
    static volatile int count = 0;

    public static void main(String[] args) {
        new ThreadWriter().start();
        new ThreadReader().start();

    }

    static class ThreadWriter extends Thread {
        @Override
        public void run() {
            while (count < 5) {
                System.out.println("increment count to" + (++count));
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class ThreadReader extends Thread {
        @Override
        public void run() {
            int localvar = count;
            while (localvar < 5) {
                if (localvar != count) {
                    System.out.println("new value of count: " + count);
                    localvar = count;
                }
            }
        }
    }
}
