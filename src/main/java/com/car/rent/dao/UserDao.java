package com.car.rent.dao;

import com.car.rent.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author nayix
 * @date 2020/6/28 20:09
 */
public interface UserDao extends CrudRepository<User, Long> {
    /**
     * 通过tel查询用户
     * @param tel
     * @return
     */
    User findUserByTel(Long tel);
}
