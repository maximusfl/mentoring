package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new CheckStatusWork(i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Future<String>> futures = executorService.invokeAll(tasks);
        executorService.shutdown();

        for (int i = 0; i < futures.size(); i++) {
            Future<String> future = futures.get(i);
            if (future.isDone()) {
                String s = future.get();
                System.out.println(s);
            }
        }
    }
}

class NotificationWork implements Runnable {
    @Override
    public void run() {
        System.out.println("Start sending email");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Email was sent");
    }
}

class CheckStatusWork implements Callable<String> {
    private static final String OK = "OK";
    private static final String ERROR = "ERROR";
    private final int id;

    public CheckStatusWork(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {

        System.out.println("Start checking smth...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        if (random.nextInt() % 2 == 0) {
            System.out.println("Result of checking: " + OK + " for id: " + id);
            return OK;
        } else {
            System.out.println("Result of checking: " + ERROR + " for id: " + id);
            return ERROR;
        }
    }
}
