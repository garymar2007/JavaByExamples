package org.gary.java8.concurrency.future;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class PaymentAccepter implements Callable<String> {
    private Boolean inventoryPresent;

    public PaymentAccepter(Boolean inventoryPresent) {
        this.inventoryPresent = inventoryPresent;
    }

    @Override
    public String call() throws Exception {
        sleep(200);
        if(inventoryPresent) {
            return "Payment Accepted";
        } else {
            return "Payment Rejected";
        }
    }
}
