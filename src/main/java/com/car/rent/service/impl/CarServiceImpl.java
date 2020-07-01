package com.car.rent.service.impl;

import com.car.rent.dao.CarDAO;
import com.car.rent.dto.CarDTO;
import com.car.rent.entity.Car;
import com.car.rent.enums.constants.State;
import com.car.rent.service.CarService;
import com.car.rent.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author nayix
 * @date 2020/6/30 16:24
 */
@Service
public class CarServiceImpl implements CarService {
    @Resource
    private CarDAO carDAO;

    @Override
    public CarDTO addCar(int price) {
        Car car = carDAO.save(Car.builder()
                .price(price)
                .state(State.NORMAL.getState())
                .createTime(new Date()).build());
        return DozerUtils.map(car, CarDTO.class);
    }

    @Override
    public void deleteCar(long cid) {
        carDAO.deleteById(cid);
    }

    @Override
    public int updatePrice(long cid, int price) {
        return carDAO.updatePrice(cid, price);
    }

    @Override
    public int updateState(long cid, String state) {
        return carDAO.updateState(cid, state);
    }

    @Override
    public CarDTO getCar(long cid) {
        Car car = carDAO.findCarsByCid(cid);
        return DozerUtils.map(car, CarDTO.class);
    }

    @Override
    public String getCarState(long cid) {
        CarDTO car = getCar(cid);
        return car == null? null: car.getState();
    }
}
