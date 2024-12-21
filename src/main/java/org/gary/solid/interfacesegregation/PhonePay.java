package org.gary.solid.interfacesegregation;

public class PhonePay implements UPIPayments {
    @Override
    public void payMoney() {
        System.out.println("Paying money using Phone Pay");
    }

    @Override
    public void getScratchCard() {
        System.out.println("Getting scratch card using Phone Pay");
    }

//    @Override
//    public void getCashBackAsCreditBalance() {
//        // NOT applicable -  this feature is not there in Phone Pay
//        System.out.println("This feature is not available in Phone Pay");
//    }
}
