package com.car.rent.controller;

import com.car.rent.dto.CarDTO;
import com.car.rent.dto.CommonResult;
import com.car.rent.enums.constants.State;
import com.car.rent.service.CarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author nayix
 * @date 2020/7/1 21:58
 */
@RestController
@RequestMapping(value = "/api/v1/cars")
public class CarController {

    @Resource
    private CarService carService;

    @PostMapping
    private CommonResult<CarDTO> addCar(@RequestParam Integer price) {
        if (price == null) {
            return CommonResult.notAcceptable();
        }
        CarDTO carDTO = carService.addCar(price);
        return CommonResult.success(carDTO);
    }

    @DeleteMapping
    private CommonResult<?> deleteCar(@RequestParam Long cid) {
        if (cid == null) {
            return CommonResult.notAcceptable();
        }
        int code = carService.deleteCar(cid);
        return CommonResult.getResultByCode(code);
    }

    @PutMapping("/price")
    private CommonResult<?> updatePrice(@RequestParam Long cid, @RequestParam Integer price) {
        if (cid == null || price == null) {
            return CommonResult.notAcceptable();
        }
        int code = carService.updatePrice(cid, price);
        return CommonResult.getResultByCode(code);
    }

    @PutMapping("/state")
    private CommonResult<?> updateState(@RequestParam Long cid, @RequestParam String state) {
        if (cid == null || !State.belongs(state)) {
            return CommonResult.notAcceptable();
        }
        int code = carService.updateState(cid, state);
        return CommonResult.getResultByCode(code);
    }

    @GetMapping
    private CommonResult<CarDTO> getCar(@RequestParam Long cid) {
        if (cid == null) {
            return CommonResult.notAcceptable();
        }
        CarDTO carDTO = carService.getCar(cid);
        return CommonResult.success(carDTO);
    }
}
