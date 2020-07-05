package com.car.rent.controller.api;

import com.car.rent.vo.CommonResult;
import com.car.rent.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.car.rent.utils.UserUtils.*;
import static com.car.rent.utils.VerifyUtils.*;

/**
 * @author nayix
 * @date 2020/7/1 16:32
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "更改用户名", httpMethod = "PUT")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String")
    @PutMapping("/username")
    private CommonResult<?> updateUsername(@RequestParam String username) {
        long uid = getUidFromSubject();
        usernameVerify(username);
        userService.updateUsername(uid, username);
        return CommonResult.success();
    }

    @ApiOperation(value = "更改密码", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPass", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "newPass", value = "新密码", required = true, dataType = "String")
    })
    @PutMapping("/password")
    private CommonResult<?> updatePassword(@RequestParam String oldPass, @RequestParam String newPass) {
        long uid = getUidFromSubject();
        passwordVerify(oldPass);
        passwordVerify(newPass);
        userService.updatePassword(uid, oldPass, newPass);
        deleteUserFromSubject();
        return CommonResult.success();
    }

    @ApiOperation(value = "充值", httpMethod = "PUT")
    @ApiImplicitParam(name = "money", value = "金额", required = true, dataType = "Integer")
    @PutMapping("/recharge")
    private CommonResult<?> recharge(@RequestParam Integer money) {
        long uid = getUidFromSubject();
        notNullVerify(money);
        // TODO 充值校验
        userService.recharge(uid, money);
        return CommonResult.success();
    }
}
