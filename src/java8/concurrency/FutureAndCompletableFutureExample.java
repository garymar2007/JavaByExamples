package java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public class FutureAndCompletableFutureExample {
    public static void main(String... args) throws ExecutionException, InterruptedException {
        FutureAndCompletableFutureExample futureAndCompletableFutureExample = new FutureAndCompletableFutureExample();
        Future<String> futureString = futureAndCompletableFutureExample.calculateAsync();
        System.out.println(futureString.get());

        //Static method completedFuture
        Future<String> completableFuture = CompletableFuture.completedFuture("Hello");
        String result = completableFuture.get();
        System.out.println(result);

        //generic funcational interface--supplier
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        System.out.println(future.get());

        //thenApply - to feed the result of a computation to another computation function
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = future1.thenApply(s -> s + " World");
        System.out.println(future2.get());

        //thenAccept - receives a consumer and passes it the result of the computation
        CompletableFuture<String> completableFuture1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<Void> future3 = completableFuture1
                .thenAccept(s -> System.out.println("Computation returned: " + s));
        future3.get();

        //thenRun - receives a runnable and does not return anything
        CompletableFuture<String> completableFuture2
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<Void> future4 = completableFuture2
                .thenRun(() -> System.out.println("Computation finished."));
        future4.get();

        //thenCompose - to chain two CompletableFutures
        CompletableFuture<String> completableFuture3
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
        System.out.println(completableFuture3.get());

        //thenAcceptBoth - to do something with two Futures' results but don't need to pass any resulting value down a Future chain.
        CompletableFuture future5 = CompletableFuture.supplyAsync(() -> "Gary")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " Ma"),
                        (s1, s2) -> System.out.println(s1 + s2));
    }

    public Future<String> calculateAsync() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(
                () -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    completableFuture.complete("Hello");
                    return null;
                }
        );

        return completableFuture;
    }
}
