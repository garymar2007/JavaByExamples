package org.gary.solid.interfacesegregation;

public class GooglePay implements UPIPayments, CashBackManager {
    @Override
    public void payMoney() {
        System.out.println("Paying money using Google Pay");
    }

    @Override
    public void getScratchCard() {
        System.out.println("Getting scratch card using Google Pay");
    }

    @Override
    public void getCashBackAsCreditBalance() {
        // this feature is there in Google Pay
        System.out.println("Getting cash back as credit balance using Google Pay");
    }
}
