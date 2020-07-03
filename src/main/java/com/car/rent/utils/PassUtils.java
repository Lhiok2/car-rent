package com.car.rent.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.security.SecureRandom;

/**
 * @author nayix
 * @date 2020/7/3 20:32
 */
public class PassUtils {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final int BYTES_NUM = 64;
    public static final int HASH_ITERATIONS = 2;

    /**
     * 生成随机盐
     * @return salt
     */
    public static String getRandomSalt() {
        byte[] bytes = new byte[BYTES_NUM];
        SECURE_RANDOM.nextBytes(bytes);
        return Base64.encodeToString(bytes);
    }

    /**
     * md5编码
     * @param password
     * @param salt
     * @return encoded_password
     */
    public static String getEncodedPass(String password, String salt) {
        Md5Hash md5Hash = new Md5Hash(password, salt, HASH_ITERATIONS);
        return md5Hash.toBase64();
    }
}
