package com.car.rent.controller;

import com.car.rent.dto.CommonResult;
import com.car.rent.dto.UserDTO;
import com.car.rent.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.car.rent.utils.PassUtils.isValidPass;
import static com.car.rent.utils.SessionUtils.deleteUserFromSession;
import static com.car.rent.utils.SessionUtils.putUserIntoSession;
import static com.car.rent.utils.TelUtils.isValidTel;

/**
 * @author nayix
 * @date 2020/7/1 13:14
 */
@RestController
@RequestMapping(value = "/api/v1/security")
public class SecurityController {

    @Resource
    private UserService userService;

    private boolean isValidTelAndPassword(String tel, String password) {
        return isValidTel(tel) && isValidPass(password);
    }

    private boolean isValidTelAndPassword(UserDTO userDTO) {
        return isValidTelAndPassword(userDTO.getTel(), userDTO.getPassword());
    }

    /**
     * 通过手机和密码注册
     * @param userDTO
     * @return
     */
    @PostMapping("/register/tel")
    private CommonResult registerByTelAndPassword(@RequestBody UserDTO userDTO) {
        if (!isValidTelAndPassword(userDTO)) {
            return CommonResult.validateFailed();
        }
        int resultCode = userService.addUser(userDTO);
        return CommonResult.getResultByCode(resultCode);
    }

    /**
     * 通过手机和密码登录
     * @param tel
     * @param password
     * @param request
     * @return
     */
    @GetMapping("/login/tel")
    private CommonResult<UserDTO> loginByTelAndPassword(@RequestParam String tel, @RequestParam String password, HttpServletRequest request) {
        if (!isValidTelAndPassword(tel, password)) {
            return CommonResult.validateFailed();
        }
        UserDTO userDTO = userService.loginByTelAndPassword(tel, password);
        if (userDTO == null) {
            return CommonResult.failed(404, "用户名或密码错误");
        }
        putUserIntoSession(request, userDTO);
        return CommonResult.success(userDTO);
    }

    /**
     * 通过手机和密码注销
     * @param tel
     * @param password
     * @param request
     * @return
     */
    @DeleteMapping("/logoff/tel")
    private CommonResult logoffByTelAndPassword(@RequestParam String tel, @RequestParam String password, HttpServletRequest request) {
        if (!isValidTelAndPassword(tel, password)) {
            return CommonResult.validateFailed();
        }
        deleteUserFromSession(request);
        int resultCode = userService.logoffByTelAndPassword(tel, password);
        return CommonResult.getResultByCode(resultCode);
    }

    /**
     * 登出
     * @param request
     * @return
     */
    @DeleteMapping("/logout")
    private CommonResult logout(HttpServletRequest request) {
        deleteUserFromSession(request);
        return CommonResult.success();
    }
}
