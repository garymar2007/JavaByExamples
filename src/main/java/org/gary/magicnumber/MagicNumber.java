package org.gary.magicnumber;

/**
 * Write a Java Program to check if any number is a magic number or not.
 * A number is said to be a magic number if after doing the sum of digits
 * in each step and in turn doing the sum of digits of that sum, the ultimate
 * result (when there is only one digit left) is 1
 */
public class MagicNumber {
    public static void main(String... args) {
        int number = 19;
        //int sum = getMagicNumberSum(number);
        int sum = getMagiNumberSum2(number);
        if (sum == 1) {
            System.out.println("It is a magic number");
        } else {
            System.out.println("It is not a magic number");
        }
    }

    public static int getMagicNumberSum(int number) {
        int sum = 0;
        while (number > 9) {
            sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            number = sum;
        }

        return sum;
    }

    public static int getMagiNumberSum2(int number) {
        int sum = 0;
        while (number > 0 || sum > 9) {
            if(number == 0) {
                number = sum;
                sum = 0;
            }
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
