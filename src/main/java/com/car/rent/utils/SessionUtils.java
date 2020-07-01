package com.car.rent.utils;

import com.car.rent.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author nayix
 * @date 2020/7/1 15:58
 */
public class SessionUtils {
    private static final String USER_NAME_IN_SESSION = "user";

    private static HttpSession getSession(HttpServletRequest request) {
        return request.getSession();
    }

    public static void putUserIntoSession(HttpServletRequest request, UserDTO userDTO) {
        getSession(request).setAttribute(USER_NAME_IN_SESSION, userDTO);
    }

    public static UserDTO getUserFromSession(HttpServletRequest request) {
        return (UserDTO) getSession(request).getAttribute(USER_NAME_IN_SESSION);
    }

    public static void deleteUserFromSession(HttpServletRequest request) {
        getSession(request).removeAttribute(USER_NAME_IN_SESSION);
    }
}
