package org.gary.diamondProblem;

public class DiamondProblem implements A, B{

    @Override
    public void print() {
        A.super.print();    // or
        //B.super.print();
    }

    public static void main(String... args){
        DiamondProblem dp = new DiamondProblem();
        dp.print();
    }
}
