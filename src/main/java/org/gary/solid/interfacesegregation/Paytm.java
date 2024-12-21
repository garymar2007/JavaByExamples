package org.gary.solid.interfacesegregation;

public class Paytm implements UPIPayments{
    @Override
    public void payMoney() {
        System.out.println("Paying money using Paytm");
    }

    @Override
    public void getScratchCard() {
        System.out.println("Getting scratch card using Paytm");
    }

//    @Override
//    public void getCashBackAsCreditBalance() {
//        // NOT applicable -  this feature is not there in Paytm
//        System.out.println("This feature is not available in Paytm");
//    }
}
