package org.gary.problemSolving;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class HashCreator {

    public static String createMD5Hash(final String input) throws NoSuchAlgorithmException {
        String hashText = null;
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] messageDigest = md.digest(input.getBytes());

        hashText = convertToHex(messageDigest);

        return hashText;
    }

    public static String createSHAHash(String input) throws NoSuchAlgorithmException {

        String hashtext = null;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest =
                md.digest(input.getBytes(StandardCharsets.UTF_8));

        hashtext = convertToHex(messageDigest);
        return hashtext;
    }

    public static String createPasswordHashWithSalt(final String textToHash) {
        try {
            byte[] salt = createSalt();
            return createSaltedHash(textToHash, salt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String createSaltedHash(String textToHash, byte[] salt)
            throws NoSuchAlgorithmException {

        String saltedHash = null;
        // Create MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        //Add salted bytes to digest
        md.update(salt);

        //Get the hash's bytes
        byte[] bytes = md.digest(textToHash.getBytes());

        //Convert it to hexadecimal format to
        //get complete salted hash in hex format
        saltedHash = convertToHex(bytes);
        return saltedHash;
    }


    //Create salt
    private static byte[] createSalt() throws NoSuchAlgorithmException, NoSuchProviderException {

        //Always use a SecureRandom generator for random salt
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }

    private static String convertToHex(final byte[] messageDigest) {
        BigInteger bigInt = new BigInteger(1, messageDigest);
        String hexText = bigInt.toString(16);
        while(hexText.length() < 32) {
            hexText = "0".concat(hexText);
        }
        return hexText;
    }
}
