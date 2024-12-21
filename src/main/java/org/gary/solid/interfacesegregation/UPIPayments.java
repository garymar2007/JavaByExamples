package org.gary.solid.interfacesegregation;

/**
 * This is to demonstrate the Interface Segregation Principle:
 * A client should never be forced to implement an interface that
 * it doesn't use or clients shouldn't be forced to depend on methods they do not use.
 */
public interface UPIPayments {

    public void payMoney();

    public void getScratchCard();
}
