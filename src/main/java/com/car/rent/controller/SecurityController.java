package com.car.rent.controller;

import com.car.rent.dto.CommonResult;
import com.car.rent.dto.UserDTO;
import com.car.rent.enums.response.ResultCode;
import com.car.rent.service.UserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.car.rent.utils.SessionUtils.deleteUserFromSession;
import static com.car.rent.utils.SessionUtils.putUserIntoSession;
import static com.car.rent.utils.StringUtils.*;

/**
 * @author nayix
 * @date 2020/7/1 13:14
 */
@Api(tags = "安全相关")
@RestController
@RequestMapping(value = "/api/v1/security")
public class SecurityController {

    @Resource
    private UserService userService;

    private boolean isValidTelAndPassword(String tel, String password) {
        return isValid(tel, TEL_PATTERN) && isValid(password, PASS_PATTERN);
    }

    @ApiOperation("通过手机号和密码进行注册")
    @PostMapping("/register/tel")
    private CommonResult<?> registerByTelAndPassword(@RequestParam String username, @RequestParam String tel, @RequestParam String password) {
        if (!isValidTelAndPassword(tel, password) || !isValid(username, NAME_PATTERN)) {
            return CommonResult.notAcceptable();
        }
        int code = userService.addUser(username, tel, password);
        return CommonResult.getResultByCode(code);
    }

    @ApiOperation("通过手机和密码登录")
    @GetMapping("/login/tel")
    private CommonResult<UserDTO> loginByTelAndPassword(@RequestParam String tel, @RequestParam String password, HttpServletRequest request) {
        if (!isValidTelAndPassword(tel, password)) {
            return CommonResult.notAcceptable();
        }
        UserDTO userDTO = userService.loginByTelAndPassword(tel, password);
        putUserIntoSession(request, userDTO);
        return CommonResult.success(userDTO);
    }

    @ApiOperation("通过手机和密码注销")
    @DeleteMapping("/logoff/tel")
    private CommonResult<?> logoffByTelAndPassword(@RequestParam String tel, @RequestParam String password, HttpServletRequest request) {
        if (!isValidTelAndPassword(tel, password)) {
            return CommonResult.notAcceptable();
        }
        deleteUserFromSession(request);
        int code = userService.logoffByTelAndPassword(tel, password);
        return CommonResult.getResultByCode(code);
    }

    @ApiOperation("登出")
    @DeleteMapping("/logout")
    private CommonResult<?> logout(HttpServletRequest request) {
        deleteUserFromSession(request);
        return CommonResult.success();
    }
}
