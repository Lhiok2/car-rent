package com.car.rent.service;

import com.car.rent.vo.UserVO;

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
    void addUser(String username, String tel, String password);

    /**
     * 删除用户
     * @param tel
     * @param password
     * @return
     */
    void logoffByTelAndPass(String tel, String password);

    /**
     * 更改用户名
     * @param uid
     * @param username
     * @return
     */
    void updateUsername(long uid, String username);

    /**
     * 更改密码
     * @param uid
     * @param oldPass
     * @param newPass
     * @return
     */
    void updatePassword(long uid, String oldPass, String newPass);

    /**
     * 登录
     * @param tel
     * @return
     */
    UserVO getUserByTel(String tel);

    /**
     * 获取个人信息
     * @param uid
     * @return
     */
    UserVO getUserByUid(long uid);

    /**
     * 充值
     * @param uid
     * @param money
     * @return
     */
    void recharge(long uid, long money);
}
