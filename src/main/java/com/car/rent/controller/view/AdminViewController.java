package com.car.rent.controller.view;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nayix
 * @date 2020/7/5 12:41
 */
@Api("管理员界面")
@Controller
@RequestMapping("/views/admin")
public class AdminViewController {

    @ApiOperation(value = "前往增加车辆界面", httpMethod = "GET")
    @GetMapping("/toCarAdd")
    public String toCarAdd() {
        return "/admin/car-add";
    }

    @ApiOperation(value = "前往车辆列表界面", httpMethod = "GET")
    @GetMapping("/toCarList")
    public String toCarList() {
        return "/admin/car-list";
    }
}
