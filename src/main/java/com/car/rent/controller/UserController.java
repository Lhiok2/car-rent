package com.car.rent.controller;

import com.car.rent.dto.CommonResult;
import com.car.rent.dto.UserDTO;
import com.car.rent.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.car.rent.utils.PassUtils.isValidPass;
import static com.car.rent.utils.TelUtils.isValidTel;

/**
 * @author nayix
 * @date 2020/7/1 16:32
 */
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Resource
    private UserService userService;

    @PutMapping("/username")
    private CommonResult updateUsername(@RequestBody UserDTO userDTO) {
        return null;
    }
}
