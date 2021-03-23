package CompletableFuture.three;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        example1();

        example2();
    }

    private static void example2() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> inpyeong = () -> {
            Thread.sleep(3000L);
            return "Inpyeong";
        };

        Callable<String> java = () -> {
            Thread.sleep(1000L);
            return "Java";
        };

        // 전부 기다린다.
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, inpyeong, java));
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }

        // 끝나는 대로..
        ExecutorService executorService1 = Executors.newFixedThreadPool(4);
        String s = executorService1.invokeAny(Arrays.asList(hello, inpyeong, java));
        System.out.println(s);

        executorService.shutdown();
    }

    private static void example1() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Start!");

        // Blocking Call
        helloFuture.get();
        // cancel하면 이후에는 get 메소드로 가져올 수 없음.
        // isDone()은 항상 True 가 된다.
//        helloFuture.cancel(false);

        System.out.println(helloFuture.isDone());
        System.out.println("End!");
        executorService.shutdown();
    }
}
