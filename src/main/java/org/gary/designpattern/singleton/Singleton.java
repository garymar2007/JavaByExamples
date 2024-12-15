package org.gary.designpattern.singleton;

public enum Singleton {
    INSTANCE;

    public void perform() {
        System.out.println("Do something " + this.hashCode());
    }
}
