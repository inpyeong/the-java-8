package CompletableFuture.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread " + Thread.currentThread().getName());
//            }
//        });
        executorService.submit(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
        });
        // graceful shutdown
        executorService.shutdown();

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);

        executorService1.submit(getRunnable("Hello"));
        executorService1.submit(getRunnable("Inpyeong"));
        executorService1.submit(getRunnable("The"));
        executorService1.submit(getRunnable("Java"));
        executorService1.submit(getRunnable("Thread"));

        executorService1.shutdown();

        ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();
        executorService2.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);
        
    }

    @org.jetbrains.annotations.NotNull
    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
