package org.gary.solid.openclose;

public class WhatsAppNotificationService implements INotificationService {
    @Override
    public void sendOTP(String medium) {
        // logic to send OTP to mobile via twilio api
    }

    @Override
    public void sendTransactionReport(String medium) {
        // logic to send transaction report
    }
}
