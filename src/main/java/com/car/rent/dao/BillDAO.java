package com.car.rent.dao;

import com.car.rent.entity.Bill;
import org.springframework.data.repository.CrudRepository;

/**
 * @author nayix
 * @date 2020/6/30 16:19
 */
public interface BillDAO extends CrudRepository<Bill, Long> {
}
