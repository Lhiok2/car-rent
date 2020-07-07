package com.car.rent.service;

import com.car.rent.vo.CarVO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author nayix
 * @date 2020/6/30 16:24
 */
public interface CarService {
    /**
     * 新增车辆
     * @param price
     * @return
     */
    long addCar(int price);

    /**
     * 删除车辆
     * @param cid
     * @return
     */
    void deleteCar(long cid);

    /**
     * 更新车辆信息
     * @param cid
     * @param price
     * @param state
     * @return
     */
    void updateCar(long cid, int price, String state);

    /**
     * 获取车辆信息
     * @param cid
     * @return
     */
    CarVO getCar(long cid);

    /**
     * 获取车辆列表
     * @param pageable
     * @return
     */
    List<CarVO> getCarList(Pageable pageable);
}
