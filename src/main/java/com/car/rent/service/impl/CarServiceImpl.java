package com.car.rent.service.impl;

import com.car.rent.constant.response.ResultCode;
import com.car.rent.domain.License;
import com.car.rent.repository.CarRepository;
import com.car.rent.repository.LicenseRepository;
import com.car.rent.vo.CarVO;
import com.car.rent.domain.Car;
import com.car.rent.constant.State;
import com.car.rent.exception.Asserts;
import com.car.rent.service.CarService;
import com.car.rent.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author nayix
 * @date 2020/6/30 16:24
 */
@Slf4j
@Service
public class CarServiceImpl implements CarService {
    @Resource
    private CarRepository carRepository;
    @Resource
    private LicenseRepository licenseRepository;

    @Override
    @Transactional
    public long addCar(int lid, String number, long price) {
        try {
            License license = licenseRepository.findByLid(lid);
            if (license == null) {
                Asserts.fail(ResultCode.VALIDATE_FAILED);
            }
            Car car = carRepository.save(Car.builder()
                    .license(license)
                    .number(number)
                    .price(price)
                    .state(State.NORMAL.getState())
                    .createTime(new Date()).build());
            return car.getCid();
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
            Car car = carRepository.findCarsByCid(cid);
            State.free(car);
            int code = carRepository.deleteCarByCid(cid);
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
    public void updateCar(long cid, int lid, String number, long price, String state) {
        try {
            Car car = carRepository.findCarsByCid(cid);
            State.free(car);
            if (!licenseRepository.existsByLid(lid)) {
                Asserts.fail(ResultCode.VALIDATE_FAILED);
            }
            int code = carRepository.updateCar(cid, lid, number, price, state);
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
    public CarVO getCar(long cid) {
        Car car = carRepository.findCarsByCid(cid);
        return DozerUtils.map(car, CarVO.class);
    }

    @Override
    public List<CarVO> getCarList(Pageable pageable) {
        Page<Car> carList = carRepository.findAll(pageable);
        return DozerUtils.mapList(carList, CarVO.class);
    }
}
