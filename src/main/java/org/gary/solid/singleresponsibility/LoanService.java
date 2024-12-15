package org.gary.solid.singleresponsibility;

public class LoanService {
    public void getLoanInterestinfo(String loanType) {
        if (loanType.equals("HomeLoan")) {
            // calculate home loan interest
        }

        if (loanType.equals("PersonalLoan")) {
            // calculate personal loan interest
        }

        if(loanType.equals("CarLoan")) {
            // calculate car loan interest
        }
    }
}
