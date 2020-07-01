package com.car.rent.utils;

import java.util.regex.Pattern;

/**
 * @author nayix
 * @date 2020/7/1 15:49
 */
public class StringUtils {
    public static final Pattern TEL_PATTERN = Pattern.compile("^((13[0-9])|(14[579])|(15[0-35-9])|(16[6])|(17[0135-8])|(18[0-9])|(19[89]))(\\d{8})$");
    public static final Pattern PASS_PATTERN = Pattern.compile("^[a-zA-Z0-9]{10,30}$");
    public static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]{2,16}$");

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isValid(String str, Pattern pattern) {
        if (isEmpty(str)) {
            return false;
        }
        return pattern.matcher(str).matches();
    }
}
