package org.gary.solid.openclose;

/**
 * This is to demonstrate the Open-close Principle
 * Open for extension and close for modification.
 * -- add more functionality without changing the existing code
 */
public class NotificationService {
    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            // send OTP to email using javaMailSender API
        }

        if (medium.equals("phone")) {
            // send OTP to phone using Twilio API
        }

        // if (medium.equals("whatsapp")) {
        //}
        //...
    }
}
