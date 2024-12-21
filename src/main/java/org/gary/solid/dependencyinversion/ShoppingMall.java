package org.gary.solid.dependencyinversion;

/**
 * This is to demonstrate the Dependency Inversion Principle
 * We must use abstraction(abstract class or interfaces) instead of concreate implementations.
 * High-level modules should not depend on low-level modules. Both should depend on abstractions.
 */
public class ShoppingMall {

    private BankCard bankCard;

    public ShoppingMall(BankCard bankCard){
        this.bankCard = bankCard;
    }

    public void doPurchaseSomething(long amount) {
        bankCard.dotransaction(amount);
    }

    public static void main(String... args) {
        ShoppingMall shoppingMall = new ShoppingMall(new DebitCard());
        shoppingMall.doPurchaseSomething(1000);

        ShoppingMall shoppingMall1 = new ShoppingMall(new CreditCard());
        shoppingMall1.doPurchaseSomething(2000);
    }
}
