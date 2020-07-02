package com.car.rent.controller;

import com.car.rent.dto.CarDTO;
import com.car.rent.dto.CommonResult;
import com.car.rent.enums.constants.State;
import com.car.rent.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @ApiOperation("添加车辆")
    @PostMapping
    private CommonResult<CarDTO> addCar(@RequestParam Integer price) {
        if (price == null) {
            return CommonResult.notAcceptable();
        }
        CarDTO carDTO = carService.addCar(price);
        return CommonResult.success(carDTO);
    }

    @ApiOperation("删除车辆")
    @DeleteMapping
    private CommonResult<?> deleteCar(@RequestParam Long cid) {
        if (cid == null) {
            return CommonResult.notAcceptable();
        }
        int code = carService.deleteCar(cid);
        return CommonResult.getResultByCode(code);
    }

    @ApiOperation("更新车辆价格")
    @PutMapping("/price")
    private CommonResult<?> updatePrice(@RequestParam Long cid, @RequestParam Integer price) {
        if (cid == null || price == null) {
            return CommonResult.notAcceptable();
        }
        int code = carService.updatePrice(cid, price);
        return CommonResult.getResultByCode(code);
    }

    @ApiOperation("更新车辆状态")
    @PutMapping("/state")
    private CommonResult<?> updateState(@RequestParam Long cid, @RequestParam String state) {
        if (cid == null || !State.belongs(state)) {
            return CommonResult.notAcceptable();
        }
        int code = carService.updateState(cid, state);
        return CommonResult.getResultByCode(code);
    }

    @ApiOperation("获取车辆信息")
    @GetMapping
    private CommonResult<CarDTO> getCar(@RequestParam Long cid) {
        if (cid == null) {
            return CommonResult.notAcceptable();
        }
        CarDTO carDTO = carService.getCar(cid);
        return CommonResult.success(carDTO);
    }
}
