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

import static com.car.rent.utils.PassUtils.*;

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
        String salt = getRandomSalt();
        String encodedPass = getEncodedPass(password, salt);
        try {
            userDAO.save(User.builder()
                    .username(username)
                    .tel(tel)
                    .password(encodedPass)
                    .salt(salt)
                    .balance(0)
                    .identity(Identity.USER.getIdentity())
                    .createTime(new Date()).build());
            return 1;
        } catch (Exception e) {
            log.error("UserService-addUser: " + e.toString());
            return 0;
        }
    }

    @Override
    public int logoffByTelAndPassword(String tel, String password) {
        String salt = userDAO.getSaltByTel(tel);
        String encodedPass = getEncodedPass(password, salt);
        return userDAO.deleteByTelAndPassword(tel, encodedPass);
    }

    @Override
    public int updateUsername(String tel, String username) {
        return userDAO.updateUsername(tel, username);
    }

    @Override
    public int updatePassword(String tel, String oldPass, String newPass) {
        String oldSalt = userDAO.getSaltByTel(tel);
        String encodedOldPass = getEncodedPass(oldPass, oldSalt);
        String newSalt = getRandomSalt();
        String encodedNewPass = getEncodedPass(newPass, newSalt);
        return userDAO.updatePassword(tel, encodedOldPass, encodedNewPass, newSalt);
    }

    @Override
    public UserDTO getUserByTel(String tel) {
        User user = userDAO.findUserByTel(tel);
        return DozerUtils.map(user, UserDTO.class);
    }

    @Override
    public void recharge(long uid, int money) {
        User user = userDAO.findUserByUid(uid);
        user.setBalance(user.getBalance() + money);
        userDAO.updateBalance(uid, user.getBalance());
    }
}
