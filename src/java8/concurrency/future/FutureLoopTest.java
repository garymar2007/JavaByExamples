package java8.concurrency.future;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureLoopTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Hello, FutureTest1!");

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Instant start = Instant.now();

        for (int i = 0; i < 10; i++) {
            System.out.println("Loop: " + i);
            // OrderFetcher
            OrderFetcher orderFetcher = new OrderFetcher();
            Future<Integer> orderFuture = executorService.submit(orderFetcher);

            // InventoryChecker
            InventoryChecker inventoryChecker = new InventoryChecker(orderFuture.get());
            System.out.println("Order Number is: " + orderFuture.get());
            Future<Boolean> inventoryFuture = executorService.submit(inventoryChecker);

            // PaymentAccepter
            PaymentAccepter paymentAccepter = new PaymentAccepter(inventoryFuture.get());
            System.out.println("Inventory Present: " + inventoryFuture.get());
            Future<String> paymentFuture = executorService.submit(paymentAccepter);
            System.out.println("Payment Status: " + paymentFuture.get());
        }

        Instant end = Instant.now();
        long timeElasped = Duration.between(start, end).toMillis();
        System.out.println("Total time: " + timeElasped + " ms");

        executorService.shutdown();
    }
}
