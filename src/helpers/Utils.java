/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.security.MessageDigest;

/**
 *
 * @author edgar
 */
public class Utils {
    
    // Use MD5 hash algorithm to hash the given password
    // MD5 is one way decription, no way to decrypt it
    // Reference Link: https://stackoverflow.com/a/6565597
    public static String MD5(String md5) {
        try {
            MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
              sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
