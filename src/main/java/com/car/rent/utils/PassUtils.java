package com.car.rent.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @author nayix
 * @date 2020/7/2 19:08
 */
public class PassUtils {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
}
