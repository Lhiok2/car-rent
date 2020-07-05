package com.car.rent.utils;

import com.car.rent.constant.Identity;
import com.car.rent.vo.UserVO;
import com.car.rent.constant.response.ResultCode;
import com.car.rent.exception.Asserts;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @author nayix
 * @date 2020/7/3 18:27
 */
public class UserUtils {
    private static final String PROFILE_NAME_IN_SESSION = "profile";

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

    private static Session getSessionFromSubject() {
        Subject subject = SecurityUtils.getSubject();
        return subject.getSession();
    }

    /**
     * 判断当前用户是否为管理员
     */
    public static boolean isAdmin() {
        UserVO userVO = getUserFromSubject();
        return Identity.ADMIN.getIdentity().equals(userVO.getIdentity());
    }

    /**
     * 将个人信息放入session
     * @param profile 个人信息
     */
    public static void putProfileIntoSession(UserVO profile) {
        Session session = getSessionFromSubject();
        session.setAttribute(PROFILE_NAME_IN_SESSION, profile);
    }

    /**
     * 将个人信息从session移除
     */
    public static void deleteProfileFromSession() {
        Session session = getSessionFromSubject();
        session.removeAttribute(PROFILE_NAME_IN_SESSION);
    }

    /**
     * @return 个人信息
     */
    public static UserVO getProfileFromSession() {
        Session session = getSessionFromSubject();
        return (UserVO) session.getAttribute(PROFILE_NAME_IN_SESSION);
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
