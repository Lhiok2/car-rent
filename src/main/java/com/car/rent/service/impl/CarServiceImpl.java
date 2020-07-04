package com.car.rent.service.impl;

import com.car.rent.dao.CarDAO;
import com.car.rent.dto.CarDTO;
import com.car.rent.entity.Car;
import com.car.rent.enums.constants.State;
import com.car.rent.exception.ApiException;
import com.car.rent.exception.Asserts;
import com.car.rent.service.CarService;
import com.car.rent.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author nayix
 * @date 2020/6/30 16:24
 */
@Slf4j
@Service
public class CarServiceImpl implements CarService {
    @Resource
    private CarDAO carDAO;

    @Override
    @Transactional
    public CarDTO addCar(int price) {
        try {
            Car car = carDAO.save(Car.builder()
                    .price(price)
                    .state(State.NORMAL.getState())
                    .createTime(new Date()).build());
            return DozerUtils.map(car, CarDTO.class);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("CarService-addCar[ message:" + e.getMessage() + "]");
            throw e;
        }
    }

    @Override
    @Transactional
    public void deleteCar(long cid) {
        try {
            int code = carDAO.deleteCarByCid(cid);
            if (code != 1) {
                Asserts.fail();
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("CarService-deleteCar[ cid:" + cid + " message:" + e.getMessage() + "]");
            throw e;
        }
    }

    @Override
    @Transactional
    public void updatePrice(long cid, int price) {
        try {
            int code = carDAO.updatePrice(cid, price);
            if (code != 1) {
                Asserts.fail();
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("CarService-updatePrice[ cid:" + cid + " message:" + e.getMessage() + "]");
            throw e;
        }
    }

    @Override
    @Transactional
    public void updateState(long cid, String state) {
        try {
            int code = carDAO.updateState(cid, state);
            if (code != 1) {
                Asserts.fail();
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("CarService-updateState[ cid:" + cid + " message:" + e.getMessage() + "]");
            throw e;
        }
    }

    @Override
    public CarDTO getCar(long cid) {
        Car car = carDAO.findCarsByCid(cid);
        return DozerUtils.map(car, CarDTO.class);
    }
}
