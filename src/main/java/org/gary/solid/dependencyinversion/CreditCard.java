package org.gary.solid.dependencyinversion;

public class CreditCard implements BankCard {

    public void dotransaction(long amount){
        System.out.println("Transaction done using Credit Card for amount = " + amount);
    }
}
