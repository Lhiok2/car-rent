package com.car.rent.controller;

import com.car.rent.dto.CommonResult;
import com.car.rent.dto.UserDTO;
import com.car.rent.enums.response.ResultCode;
import com.car.rent.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.car.rent.utils.StringUtils.*;
import static com.car.rent.utils.SubjectUtils.deleteUserFromSubject;
import static com.car.rent.utils.SubjectUtils.getUserFromSubject;

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

    @ApiOperation("更改用户名")
    @PutMapping("/username")
    private CommonResult<?> updateUsername(@RequestParam String username) {
        UserDTO userDTO = getUserFromSubject();
        if (userDTO == null) {
            return CommonResult.unauthorized();
        } else if (!isValid(username, NAME_PATTERN)) {
            return CommonResult.notAcceptable();
        }
        userDTO.setUsername(username);
        int code = userService.updateUsername(userDTO.getTel(), username);
        return CommonResult.getResultByCode(code);
    }

    @ApiOperation("更改密码")
    @PutMapping("/password")
    private CommonResult<?> updatePassword(@RequestParam String oldPass, @RequestParam String newPass) {
        UserDTO userDTO = getUserFromSubject();
        if (userDTO == null) {
            return CommonResult.unauthorized();
        } else if (!isValid(oldPass, PASS_PATTERN) || !isValid(newPass, PASS_PATTERN)) {
            return CommonResult.notAcceptable();
        }
        int code = userService.updatePassword(userDTO.getTel(), oldPass, newPass);
        deleteUserFromSubject();
        return CommonResult.getResultByCode(code, ResultCode.FORBIDDEN);
    }

    @ApiOperation("充值")
    @PutMapping("/recharge")
    private CommonResult<?> recharge(@RequestParam Integer money) {
        UserDTO userDTO = getUserFromSubject();
        // TODO 充值校验
        userService.recharge(userDTO.getUid(), money);
        return CommonResult.success();
    }
}
