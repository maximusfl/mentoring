package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName());

        CompletionStage<String> stage = CompletableFuture.supplyAsync(() -> Thread.currentThread().getName() + " test");

        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("hello from: " + Thread.currentThread().getName());
                    return 1;
                }).thenApplyAsync(i -> "result " + i);


        String s2 = future.thenCombine(stage, (s, s1) -> {
            return s + " " + s1;
        }).get();

        System.out.println(s2);

        System.out.println(Thread.currentThread().getName());

    }
}

