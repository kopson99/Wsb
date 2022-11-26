package pl.wojtek.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Sha256Util {

    private static final String salt = "MY_SALT";
    public static String sha256(String base) {
        try {
            base = base + salt;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}