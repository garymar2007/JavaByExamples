package org.gary.exception;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            throw new CustomizedException("This is a customized exception");
        } catch (CustomizedException e) {
            e.printStackTrace();
        }
    }
}
