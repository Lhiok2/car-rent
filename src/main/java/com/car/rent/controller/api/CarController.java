package com.car.rent.controller.api;

import com.car.rent.vo.CarVO;
import com.car.rent.vo.CommonResult;
import com.car.rent.constant.State;
import com.car.rent.service.CarService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.car.rent.utils.VerifyUtils.*;

/**
 * @author nayix
 * @date 2020/7/1 21:58
 */
@Api(tags = "车辆管理")
@RestController
@RequestMapping(value = "/api/v1/cars")
public class CarController {

    @Resource
    private CarService carService;

    @ApiOperation(value = "添加车辆", httpMethod = "POST")
    @ApiImplicitParam(name = "price", value = "单价", required = true, dataType = "Integer")
    @PostMapping
    private CommonResult<CarVO> addCar(@RequestParam Integer price) {
        adminVerify();
        notNullVerify(price);
        CarVO carVO = carService.addCar(price);
        return CommonResult.success(carVO);
    }

    @ApiOperation(value = "删除车辆", httpMethod = "DELETE")
    @ApiImplicitParam(name = "cid", value = "车辆id", required = true, dataType = "Long")
    @DeleteMapping
    private CommonResult<?> deleteCar(@RequestParam Long cid) {
        adminVerify();
        notNullVerify(cid);
        carService.deleteCar(cid);
        return CommonResult.success();
    }

    @ApiOperation(value = "更新车辆价格", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cid", value = "车辆id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "price", value = "价格", required = true, dataType = "Integer")
    })
    @PutMapping("/price")
    private CommonResult<?> updatePrice(@RequestParam Long cid, @RequestParam Integer price) {
        adminVerify();
        notNullVerify(cid, price);
        carService.updatePrice(cid, price);
        return CommonResult.success();
    }

    @ApiOperation(value = "更新车辆状态", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cid", value = "车辆id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "state", value = "车辆状态", required = true, dataType = "String")
    })
    @PutMapping("/state")
    private CommonResult<?> updateState(@RequestParam Long cid, @RequestParam String state) {
        adminVerify();
        notNullVerify(cid);
        stringVerify(state, State.toStringList());
        carService.updateState(cid, state);
        return CommonResult.success();
    }

    @ApiOperation(value = "获取车辆信息", httpMethod = "GET")
    @ApiImplicitParam(name = "cid", value = "车辆id", required = true, dataType = "Long")
    @GetMapping
    private CommonResult<CarVO> getCar(@RequestParam Long cid) {
        notNullVerify(cid);
        CarVO carVO = carService.getCar(cid);
        return CommonResult.success(carVO);
    }
}
