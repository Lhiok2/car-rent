package com.car.rent.dao;

import com.car.rent.entity.Car;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nayix
 * @date 2020/6/28 20:10
 */
public interface CarDAO extends CrudRepository<Car, Long> {
    /**
     * 通过id获取车辆信息
     * @param cid
     * @return
     */
    Car findCarsByCid(Long cid);

    /**
     * 更新价格
     * @param cid
     * @param price
     * @return
     */
    @Modifying
    @Transactional
    @Query("update Car set price = :price where cid = :cid")
    int updatePrice(long cid, int price);

    /**
     * 更新车辆状态
     * @param cid
     * @param state
     * @return
     */
    @Modifying
    @Transactional
    @Query("update Car set state = :state where cid = :cid")
    int updateState(long cid, String state);
}
