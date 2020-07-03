package com.car.rent.service;

import com.car.rent.dto.UserDTO;

/**
 * @author nayix
 * @date 2020/6/30 16:23
 */
public interface UserService {
    /**
     * 添加用户
     * @param username
     * @param tel
     * @param password
     * @return
     */
    int addUser(String username, String tel, String password);

    /**
     * 删除用户
     * @param tel
     * @param password
     * @return
     */
    int logoffByTelAndPassword(String tel, String password);

    /**
     * 更改用户名
     * @param tel
     * @param username
     * @return
     */
    int updateUsername(String tel, String username);

    /**
     * 更改密码
     * @param tel
     * @param oldPass
     * @param newPass
     * @return
     */
    int updatePassword(String tel, String oldPass, String newPass);

    /**
     * 登录
     * @param tel
     * @return
     */
    UserDTO getUserByTel(String tel);

    /**
     * 充值
     * @param uid
     * @param money
     * @return
     */
    void recharge(long uid, int money);
}
