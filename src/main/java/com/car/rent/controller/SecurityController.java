package com.car.rent.controller;

import com.car.rent.dto.CommonResult;
import com.car.rent.dto.UserDTO;
import com.car.rent.service.UserService;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import static com.car.rent.utils.StringUtils.*;
import static com.car.rent.utils.SubjectUtils.deleteUserFromSubject;

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
    @PostMapping("/login/tel")
    private CommonResult<UserDTO> loginByTelAndPassword(@RequestParam String tel, @RequestParam String password) {
        if (!isValidTelAndPassword(tel, password)) {
            return CommonResult.notAcceptable();
        }
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(tel, password);
        // 执行登录方法，无异常说明登陆成功
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            // 账号不存在
            return CommonResult.notFound();
        } catch (IncorrectCredentialsException e) {
            // 密码错误
            return CommonResult.forbidden();
        } catch (Exception e) {
            // 未知错误
            return CommonResult.internalError();
        }
        return CommonResult.success();
    }

    @ApiOperation("通过手机和密码注销")
    @PostMapping("/logoff/tel")
    private CommonResult<?> logoffByTelAndPassword(@RequestParam String tel, @RequestParam String password) {
        if (!isValidTelAndPassword(tel, password)) {
            return CommonResult.notAcceptable();
        }
        deleteUserFromSubject();
        int code = userService.logoffByTelAndPassword(tel, password);
        return CommonResult.getResultByCode(code);
    }

    @ApiOperation("登出")
    @PostMapping("/logout")
    private CommonResult<?> logout() {
        deleteUserFromSubject();
        return CommonResult.success();
    }
}
