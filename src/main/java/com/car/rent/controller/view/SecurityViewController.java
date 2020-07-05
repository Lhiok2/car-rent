package com.car.rent.controller.view;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nayix
 * @date 2020/7/5 12:33
 */
@Api("安全相关界面")
@Controller
@RequestMapping("/views/security")
public class SecurityViewController {

    @ApiOperation(value = "前往登录界面", httpMethod = "GET")
    @GetMapping("/toLogin")
    public String toIndex() {
        return "/security/login";
    }

    @ApiOperation(value = "前往注销界面", httpMethod = "GET")
    @GetMapping("/toLogoff")
    public String toLogoff() {
        return "/security/logoff";
    }

    @ApiOperation(value = "前往注册界面", httpMethod = "GET")
    @GetMapping("/toRegister")
    public String toRegister() {
        return "/security/register";
    }
}
