package java8.concurrency.future;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class InventoryChecker implements Callable<Boolean> {
    private Integer Order;
    public InventoryChecker(Integer Order) {
        this.Order = Order;
    }
    @Override
    public Boolean call() throws Exception {
        sleep(200);
        if (Order % 2 == 0) {
            return true;
        }
        return false;
    }
}
