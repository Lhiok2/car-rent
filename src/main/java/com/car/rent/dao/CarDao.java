package com.car.rent.dao;

import com.car.rent.entity.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * @author nayix
 * @date 2020/6/28 20:10
 */
public interface CarDao extends CrudRepository<Car, Long> {
}
