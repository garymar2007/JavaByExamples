package org.gary.solid.openclose;

public class EmailNotificationService implements INotificationService {
    @Override
    public void sendOTP(String medium) {
        // logic to send OTP
    }

    @Override
    public void sendTransactionReport(String medium) {
        // logic to send transaction report
    }
}
