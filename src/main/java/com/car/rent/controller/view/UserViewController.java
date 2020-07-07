package com.car.rent.controller.view;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nayix
 * @date 2020/7/5 12:37
 */
@Api("用户界面")
@Controller
@RequestMapping("/views/user")
public class UserViewController {

    @ApiOperation(value = "前往更改用户名界面", httpMethod = "GET")
    @GetMapping("/toChangeName")
    public String toChangeName() {
        return "/user/change-name";
    }

    @ApiOperation(value = "前往更改密码界面", httpMethod = "GET")
    @GetMapping("/toChangePass")
    public String toChangePass() {
        return "/user/change-pass";
    }

    @ApiOperation(value = "前往首页", httpMethod = "GET")
    @GetMapping("/toIndex")
    public String toIndex() {
        return "/user/index";
    }

    @ApiOperation(value = "前往订单界面", httpMethod = "GET")
    @GetMapping("/toOrders")
    public String toOrders() {
        return "/user/orders";
    }

    @ApiOperation(value = "前往个人信息界面", httpMethod = "GET")
    @GetMapping("/toProfile")
    public String toProfile() {
        return "/user/profile";
    }

    @ApiOperation(value = "前往充值界面", httpMethod = "GET")
    @GetMapping("/toRecharge")
    public String toRecharge() {
        return "/user/recharge";
    }
}
