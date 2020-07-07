package com.car.rent.repository;

import com.car.rent.domain.License;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author nayix
 * @date 2020/7/7 21:48
 */
public interface LicenseRepository extends CrudRepository<License, Integer> {
    /**
     * 查询区号是否存在
     * @param lid
     * @return
     */
    boolean existsByLid(Integer lid);

    /**
     * 通过id获取区号信息
     * @param lid
     * @return
     */
    License findByLid(Integer lid);

    /**
     * 获取区号列表
     * @return
     */
    @Query("select l from License l")
    List<License> getAll();
}
