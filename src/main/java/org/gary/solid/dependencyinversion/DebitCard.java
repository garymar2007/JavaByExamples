package org.gary.solid.dependencyinversion;

public class DebitCard implements BankCard {
    public void dotransaction(long amount){
        System.out.println("Transaction done using Debit Card for amount = " + amount);
    }
}
