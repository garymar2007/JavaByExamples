package org.gary.java8.defaultmethod;

public class DiamondProblemDemo implements DiamondProblemInterface1, DiamondProblemInterface2{
    @Override
    public void m1() {
        DiamondProblemInterface2.super.m1();
    }

    public static void main(String... args) {
        DiamondProblemDemo default1 = new DiamondProblemDemo();
        default1.m1();
    }
}
