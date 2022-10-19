package problemSolving;

import java.util.Scanner;

public class StackSplit {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a number for the size of a stack:");
        int size = Integer.parseInt(sc.nextLine());
        System.out.println("Please input a number for the threshold of a stack");
        int threshold = Integer.parseInt(sc.nextLine());

        System.out.println("This stack will be split into " + splitStack(size, threshold) + " sub-stacks.");
    }

    static int splitStack(int size, int threshold){
        if(size % threshold == 0){
            return size / threshold;
        } else {
            return size / threshold + 1;
        }
    }
}
