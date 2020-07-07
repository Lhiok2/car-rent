package com.car.rent.repository;

import com.car.rent.domain.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nayix
 * @date 2020/6/28 20:10
 */
public interface CarRepository extends CrudRepository<Car, Long> {
    /**
     * 通过id获取车辆信息
     * @param cid
     * @return
     */
    Car findCarsByCid(long cid);

    /**
     * 获取车辆列表
     * @param pageable
     * @return
     */
    Page<Car> findAll(Pageable pageable);

    /**
     * 更新车辆信息
     * @param cid
     * @param lid
     * @param number
     * @param price
     * @param state
     * @return
     */
    @Modifying
    @Transactional
    @Query("update Car set license.lid = :lid, number = :number, price = :price, state = :state where cid = :cid")
    int updateCar(long cid, int lid, String number, int price, String state);

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

    /**
     * 通过id删除车辆
     * @param cid
     * @return
     */
    @Modifying
    @Transactional
    @Query("delete from Car where cid = :cid")
    int deleteCarByCid(long cid);
}
