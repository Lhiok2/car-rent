package com.car.rent.service;

import com.car.rent.vo.CarVO;

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
     * 更新价格
     * @param cid
     * @param price
     * @return
     */
    void updatePrice(long cid, int price);

    /**
     * 更新状态
     * @param cid
     * @param state
     * @return
     */
    void updateState(long cid, String state);

    /**
     * 获取车辆信息
     * @param cid
     * @return
     */
    CarVO getCar(long cid);
}
