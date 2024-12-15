package org.gary.solid.singleresponsibility;

/**
 * This is to demonstrate the Open-close Principle
 * Open for extension and close for modification.
 */
public class NotificationService {
    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            // send OTP to email using javaMailSender API
        }

        if (medium.equals("phone")) {
            // send OTP to phone using Twilio API
        }
    }
}
