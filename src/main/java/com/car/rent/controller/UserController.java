package com.car.rent.controller;

import com.car.rent.dto.CommonResult;
import com.car.rent.dto.UserDTO;
import com.car.rent.enums.response.ResultCode;
import com.car.rent.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.car.rent.utils.SessionUtils.deleteUserFromSession;
import static com.car.rent.utils.SessionUtils.getUserFromSession;
import static com.car.rent.utils.StringUtils.*;

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
    private CommonResult<?> updateUsername(@RequestParam String username, HttpServletRequest request) {
        UserDTO userDTO = getUserFromSession(request);
        if (userDTO == null) {
            return CommonResult.unauthorized();
        } else if (!isValid(username, NAME_PATTERN)) {
            return CommonResult.notAcceptable();
        }
        userDTO.setUsername(username);
        int code = userService.updateUsername(userDTO.getTel(), username);
        return CommonResult.getResultByCode(code);
    }

    @PutMapping("/password")
    private CommonResult<?> updatePassword(@RequestParam String oldPass, @RequestParam String newPass, HttpServletRequest request) {
        UserDTO userDTO = getUserFromSession(request);
        if (userDTO == null) {
            return CommonResult.unauthorized();
        } else if (!isValid(oldPass, PASS_PATTERN) || !isValid(newPass, PASS_PATTERN)) {
            return CommonResult.notAcceptable();
        }
        int resultCode = userService.updatePassword(userDTO.getTel(), oldPass, newPass);
        deleteUserFromSession(request);
        return CommonResult.getResultByCode(resultCode, ResultCode.FORBIDDEN);
    }
}
