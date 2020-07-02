package com.car.rent.service.impl;

import com.car.rent.dao.UserDAO;
import com.car.rent.dto.UserDTO;
import com.car.rent.entity.User;
import com.car.rent.enums.constants.Identity;
import com.car.rent.service.UserService;
import com.car.rent.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author nayix
 * @date 2020/6/30 16:24
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    @Override
    public int addUser(String username, String tel, String password) {
        try {
            userDAO.save(User.builder()
                    .username(username)
                    .tel(tel)
                    .password(password)
                    .balance(0)
                    .identity(Identity.USER.getIdentity())
                    .createTime(new Date())
                    .lastEditTime(new Date()).build());
            return 1;
        } catch (Exception e) {
            log.error("UserService-addUser: " + e.toString());
            return 0;
        }
    }

    @Override
    public int logoffByTelAndPassword(String tel, String password) {
        return userDAO.deleteByTelAndPassword(tel, password);
    }

    @Override
    public int updateUsername(String tel, String username) {
        return userDAO.updateUsername(tel, username);
    }

    @Override
    public int updatePassword(String tel, String oldPass, String newPass) {
        return userDAO.updatePassword(tel, oldPass, newPass);
    }

    @Override
    public UserDTO loginByTelAndPassword(String tel, String password) {
        User user = userDAO.findUserByTelAndPassword(tel, password);
        return DozerUtils.map(user, UserDTO.class);
    }

    @Override
    public UserDTO recharge(long uid, int money) {
        User user = userDAO.findUserByUid(uid);
        user.setBalance(user.getBalance() + money);
        userDAO.updateBalance(uid, user.getBalance());
        return DozerUtils.map(user, UserDTO.class);
    }
}
