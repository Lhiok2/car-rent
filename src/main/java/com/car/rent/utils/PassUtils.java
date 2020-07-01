package com.car.rent.utils;

/**
 * @author nayix
 * @date 2020/7/1 16:50
 */
public class PassUtils extends StringUtils {
    private static final String pattern = "^[a-z,A-Z,0-9]{10,30}$";

    public static boolean isValidPass(String pass) {
        return pattern.matches(pass);
    }
}
