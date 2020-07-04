package com.car.rent.utils;

import com.car.rent.dto.UserDTO;
import com.car.rent.enums.response.ResultCode;
import com.car.rent.exception.Asserts;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author nayix
 * @date 2020/7/3 18:27
 */
public class UserUtils {
    /**
     * @return currentUser
     */
    public static UserDTO getUserFromSubject() {
        // 拿到当前登录对象信息
        Subject subject = SecurityUtils.getSubject();
        // 获取认证方法传递的用户信息
        UserDTO userDTO = (UserDTO) subject.getPrincipal();
        if (userDTO == null) {
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        return userDTO;
    }

    /**
     * @return currentUid
     */
    public static long getUidFromSubject() {
        return getUserFromSubject().getUid();
    }

    /**
     * 删除currentUser信息 实现登出
     */
    public static void deleteUserFromSubject() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
