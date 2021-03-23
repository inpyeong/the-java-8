package CompletableFuture.four;

import java.util.concurrent.*;
import java.util.function.Function;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        example();
//        example1();
//        example2();
        example3();
    }

    private static void example3() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executorService).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        future.get();
    }

    private static void example2() throws ExecutionException, InterruptedException {
        // 리턴 타입이 없는 경우
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        });
//        future.get();

        // 리턴 타입이 있는 경우
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello1 " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply(new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println(Thread.currentThread().getName());
                return s.toUpperCase();
            }
        });
        System.out.println(future1.get());

        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello2 " + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });
        future2.get();

        CompletableFuture<Void> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello2 " + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        future3.get();
    }

    private static void example1() {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("inpyeong");

//        CompletableFuture<String> future = CompletableFuture.completedFuture("inpyeong");
    }

    private static void example() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(() -> "hello");

        // TODO

        // blocking call
        future.get();
    }
}
