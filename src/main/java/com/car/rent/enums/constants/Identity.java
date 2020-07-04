package com.car.rent.enums.constants;

import com.car.rent.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<String> toStringList() {
        return Arrays.stream(Identity.values()).map(Identity::getIdentity).collect(Collectors.toList());
    }

    public static boolean hasAdminRole(UserDTO userDTO) {
        return ADMIN.identity.equals(userDTO.getIdentity());
    }

    public static boolean hasUserRole(UserDTO userDTO) {
        String identityStr = userDTO.getIdentity();
        return USER.identity.equals(identityStr) || ADMIN.identity.equals(identityStr);
    }
}
