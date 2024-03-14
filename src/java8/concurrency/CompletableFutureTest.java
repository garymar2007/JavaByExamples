package java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

    public static void main(String... args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            // Simulate some asynchronous task
            try{
                System.out.println("Executing somthing ...");
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }

            // Return the result
            return "Hello CompletableFuture!";
        });

        // Perform an action when the CompletableFuture completes
        completableFuture.thenAccept((result) -> {
            System.out.println(result);
        });

        // Block and wait for the CompletableFuture to complete
        try{
            completableFuture.get();
        }catch(InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
