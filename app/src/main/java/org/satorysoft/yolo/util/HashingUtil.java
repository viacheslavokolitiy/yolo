package org.satorysoft.yolo.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingUtil {

    public String generateMD5String(String data) throws NoSuchAlgorithmException {
        MessageDigest md;
        StringBuilder hexBuilder = new StringBuilder();
        md = MessageDigest.getInstance("MD5");
        md.update(data.getBytes());

        byte byteData[] = md.digest();

        for (byte value : byteData) {
            hexBuilder.append(Integer.toString((value & 0xff) + 0x100, 16).substring(1));
        }

        return hexBuilder.toString();

    }
}
