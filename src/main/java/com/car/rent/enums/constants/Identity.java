package com.car.rent.enums.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nayix
 * @date 2020/6/28 19:50
 */
@Getter
@AllArgsConstructor
public enum Identity {
    // admin
    ADMIN("Admin"),

    // user
    USER("User"),

    // banned_user
    USER_BANNED("Banned"),

    // frozen_user
    USER_FROZEN("Frozen")
    ;

    private final String identity;

    public static boolean hasAdminRole(String identityStr) {
        return identityStr.equals(ADMIN.identity);
    }

    public static boolean hasUserRole(String identityStr) {
        return identityStr.equals(USER.identity) || identityStr.equals(ADMIN.identity);
    }
}
