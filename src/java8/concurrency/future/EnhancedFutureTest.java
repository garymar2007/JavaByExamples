package java8.concurrency.future;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.Thread.sleep;

public class EnhancedFutureTest {

    public EnhancedFutureTest() {
        System.out.println("Hello, EnhancedFutureTest constructor!");
    }

    public static void main(String[] args) {
        System.out.println("Hello, EnhancedFutureTest Main!");
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Instant start = Instant.now();
        System.out.println("Start time: " + start);

        Supplier<Integer> orderFetcher = () -> {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int random = ThreadLocalRandom.current().nextInt(6);
            System.out.println(Thread.currentThread().getName() +  "order fetched " + random + " ");
            return random;
        };

        Function<Integer, Boolean> inventoryChecker = orderNumber -> {
            if(orderNumber % 2 == 0) {
                return true;
            }
            return false;
        };

        Consumer<Boolean> paymentAcceptor = inventoryPresent -> {
            if(inventoryPresent) {
                System.out.println(Thread.currentThread().getName() + " Payment Accepted");
            } else {
                System.out.println(Thread.currentThread().getName() + " Payment Rejected");
            }
            Instant end = Instant.now();
            System.out.println("End time: " + end);
        };

        for (int i = 0; i < 10; i++) {
            CompletableFuture future = CompletableFuture
                    .supplyAsync(orderFetcher, executorService)
                    .thenApply(inventoryChecker)
                    .thenAccept(paymentAcceptor);
        }

        executorService.shutdown();
    }
}
