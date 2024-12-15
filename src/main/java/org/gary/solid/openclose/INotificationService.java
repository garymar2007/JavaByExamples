package org.gary.solid.openclose;

public interface INotificationService {
    public void sendOTP(String medium);

    public void sendTransactionReport(String medium);
}
