package com.car.rent.utils;

import com.car.rent.enums.constants.BillState;
import com.car.rent.enums.constants.Identity;
import com.car.rent.enums.constants.State;
import com.car.rent.enums.response.ResultCode;
import com.car.rent.exception.Asserts;

import java.util.List;
import java.util.regex.Pattern;

import static com.car.rent.enums.constants.Identity.hasAdminRole;
import static com.car.rent.utils.UserUtils.getUserFromSubject;

/**
 * @author nayix
 * @date 2020/7/4 17:23
 */
public class VerifyUtils {
    private static final Pattern TEL_PATTERN = Pattern.compile("^((13[0-9])|(14[579])|(15[0-35-9])|(16[6])|(17[0135-8])|(18[0-9])|(19[89]))(\\d{8})$");
    private static final Pattern PASS_PATTERN = Pattern.compile("^[a-zA-Z0-9]{10,30}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]{2,16}$");

    /**
     * 判断字符串是否为空
     */
    public static void stringVerify(String... strings) {
        for (String str : strings) {
            if (str == null || str.isEmpty()) {
                Asserts.fail(ResultCode.VALIDATE_FAILED);
            }
        }
    }

    /**
     * 判断字符串格式
     */
    public static void stringVerify(String str, Pattern pattern) {
        stringVerify(str);
        if (!pattern.matcher(str).matches()) {
            Asserts.fail(ResultCode.VALIDATE_FAILED);
        }
    }

    /**
     * 判断字符串是否属于集合
     */
    public static void stringVerify(String data, List<String> stringList) {
        stringVerify(data);
        for (String str : stringList) {
            if (data.equals(str)) {
                return;
            }
        }
        Asserts.fail(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 判断手机格式
     */
    public static void telVerify(String tel) {
        stringVerify(tel, TEL_PATTERN);
    }

    /**
     * 判断密码格式
     */
    public static void passwordVerify(String password) {
        stringVerify(password, PASS_PATTERN);
    }

    /**
     * 判断用户名格式
     */
    public static void usernameVerify(String username) {
        stringVerify(username, NAME_PATTERN);
    }

    /**
     * 判断当前用户是否是管理员
     */
    public static void adminVerify() {
        if (!hasAdminRole(getUserFromSubject())) {
            Asserts.fail(ResultCode.FORBIDDEN);
        }
    }

    /**
     * 判断参数是否全部非空
     */
    public static void notNullVerify(Object... objects) {
        for (Object obj : objects) {
            if (obj == null) {
                Asserts.fail(ResultCode.VALIDATE_FAILED);
            }
        }
    }
}
