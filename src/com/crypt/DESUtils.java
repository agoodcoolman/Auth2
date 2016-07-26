package com.crypt;

import org.apache.commons.codec.binary.Base64;

/**
 * 	Des加密解密工具类
  *
 */
public class DESUtils {
	/**
     * 加密
     * @param encrypt
     */
    public static byte[] DESencrypt(byte[] encrypt) {

        try {
            return DES.decrypt(encrypt, DES.PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /**
     * 解密
     * @param decrypt
     */
    public static byte[] DESdecrypt(byte[] decrypt) {
        try {
        	
            return DES.decrypt(decrypt, DES.PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
