package org.gary.solid.singleresponsibility;

/**
 * This is to demonstrate the Single Responsibility Principle
 *
 * The single responsibility principle states that every Java class must perform a single
 * functionality.
 */
public class BankService {
    public long deposit(long amount, String accountNo) {
        return 0;
    }

    public long withdraw(long amount, String accountNo) {
        return 0;
    }

    // TODO: Move to printer service
//    public void printPassbook() {
//
//    }

    // TODO: Move to loan service
//    public void getLoanInterestinfo(String loanType) {
//        if (loanType.equals("HomeLoan")) {
//            // calculate home loan interest
//        }
//
//        if (loanType.equals("PersonalLoan")) {
//            // calculate personal loan interest
//        }
//
//        if(loanType.equals("CarLoan")) {
//            // calculate car loan interest
//        }
//    }

    // TODO: Move to notification service
//    public void sendOTP(String medium) {
//        if (medium.equals("email")) {
//            // send OTP to email
//        }
//
//        if (medium.equals("phone")) {
//            // send OTP to phone
//        }
//    }

}
