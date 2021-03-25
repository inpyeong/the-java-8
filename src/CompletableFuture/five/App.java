package CompletableFuture.five;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        // hello 뒤에 world 를 실행한다.
        CompletableFuture<String> future = hello.thenCompose(App::getWorld);

        System.out.println(future.get());

        ///////////////////////////

        CompletableFuture<String> hello1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello1 " + Thread.currentThread().getName());
            return "Hello1";
        });

        CompletableFuture<String> world1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("World1 " + Thread.currentThread().getName());
            return "World1";
        });

        CompletableFuture<String> future1 = hello.thenCombine(world1, (h, w) -> {
            return h + " " + w;
        });
        // 두 개 동시에 실행
        // 두 개의 결과가 나오면 BiFunction 에서 처리 가능
        System.out.println(future1.get());

        //////////////////////////

        // 2개 이상일 때 여러 Task 들을 합쳐서 실행
        // 하지만 모든 결과들이 동일한 타입이라는 보장이 없음.
        // 어떤 Task 는 에러가 발생했을 수도 있음.
        // 그래서 무의미하다..
        // NULL 이 나온다.
        CompletableFuture<Void> future2 = CompletableFuture.allOf(hello1, world1)
                .thenAccept(System.out::println);

        System.out.println(future2.get());

        // 만약 Collection 에 넣고 싶다면
        List<CompletableFuture<String>> futures = Arrays.asList(hello1, world1);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> {
                    return futures.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList());
                });
        results.get().forEach(System.out::println);

        //////////////////////////

        // 아무거나 하나 빨리 끝나는 Task 받기.
        CompletableFuture<Void> future3 = CompletableFuture.anyOf(hello1, world1).thenAccept(System.out::println);
        future3.get();


        ///////////////////////

        // 에러처리
        boolean throwError = true;

        CompletableFuture<String> _hello = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });
        System.out.println(_hello.get());

        // handle 사용
        CompletableFuture<String> __hello = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> {
            if(ex != null) {
                System.out.println(ex);
                return "Error!";
            }
            return result;
        });
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + "World";
        });
    }
}
