package com.car.rent.service;

import com.car.rent.dto.UserDTO;

/**
 * @author nayix
 * @date 2020/6/30 16:23
 */
public interface UserService {
    /**
     * 添加用户
     * @param userDTO
     * @return
     */
    int addUser(UserDTO userDTO);

    /**
     * 删除用户
     * @param tel
     * @param password
     * @return
     */
    int logoffByTelAndPassword(String tel, String password);

    /**
     * 更新用户信息
     * @param userDTO
     * @return
     */
    int updateUser(UserDTO userDTO);

    /**
     * 登录
     * @param tel
     * @param password
     * @return
     */
    UserDTO loginByTelAndPassword(String tel, String password);
}
