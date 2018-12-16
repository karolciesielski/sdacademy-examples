package pl.sdacademy.runnable.concurrency;

import com.google.common.util.concurrent.Futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Integer> result3 = executorService.submit(() -> 5);
        Future<Integer> result2 = executorService.submit(() -> 4);
        Future<Integer> result1 = executorService.submit(() -> 3);
        Future<Integer> result = executorService.submit(() -> 7);

        System.out.println(result.get() + result1.get() + result2.get() + result3.get());
        executorService.shutdown();

    }
}
