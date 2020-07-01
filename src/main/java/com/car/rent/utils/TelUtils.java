package com.car.rent.utils;

/**
 * @author nayix
 * @date 2020/7/1 16:36
 */
public class TelUtils extends StringUtils {
    private static final String pattern = "^((13[0-9])|(14[579])|(15[0-3,5-9])|(16[6])|(17[013,5-8])|(18[0-9])|(19[89]))\\d{8}$";

    public static boolean isValidTel(String tel) {
        if (isEmpty(tel)) {
            return false;
        }
        return pattern.matches(tel);
    }
}
