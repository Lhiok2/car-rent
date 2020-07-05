package com.car.rent.utils;

import com.car.rent.vo.UserVO;
import com.car.rent.constant.response.ResultCode;
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
    public static UserVO getUserFromSubject() {
        // 拿到当前登录对象信息
        Subject subject = SecurityUtils.getSubject();
        // 获取认证方法传递的用户信息
        UserVO userVO = (UserVO) subject.getPrincipal();
        if (userVO == null) {
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        return userVO;
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
