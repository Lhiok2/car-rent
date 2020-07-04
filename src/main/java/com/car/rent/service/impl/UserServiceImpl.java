package com.car.rent.service.impl;

import com.car.rent.dao.UserDAO;
import com.car.rent.dto.UserDTO;
import com.car.rent.entity.User;
import com.car.rent.enums.constants.Identity;
import com.car.rent.enums.response.ResultCode;
import com.car.rent.exception.ApiException;
import com.car.rent.exception.Asserts;
import com.car.rent.service.UserService;
import com.car.rent.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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

    @Transactional
    @Override
    public void addUser(String username, String tel, String password) {
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
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("UserService-addUser[ tel:" + tel + " message:" + e.getMessage() + "]");
            throw e;
        }
    }

    @Transactional
    @Override
    public void logoffByTelAndPass(String tel, String password) {
        try {
            String salt = userDAO.getSaltByTel(tel);
            String encodedPass = getEncodedPass(password, salt);
            int code = userDAO.deleteByTelAndPassword(tel, encodedPass);
            if (code != 1) {
                Asserts.fail(ResultCode.FORBIDDEN);
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("UserService-logoffByTelAndPass[ tel:" + tel + " message:" + e.getMessage() + "]");
            throw e;
        }
    }

    @Override
    public void updateUsername(long uid, String username) {
        try {
            int code = userDAO.updateUsername(uid, username);
            if (code != 1) {
                Asserts.fail();
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("UserService-updateUsername[ uid:" + uid + " message:" + e.getMessage() + "]");
            throw e;
        }
    }

    @Override
    public void updatePassword(long uid, String oldPass, String newPass) {
        try {
            String oldSalt = userDAO.getSaltByUid(uid);
            String encodedOldPass = getEncodedPass(oldPass, oldSalt);
            String newSalt = getRandomSalt();
            String encodedNewPass = getEncodedPass(newPass, newSalt);
            int code = userDAO.updatePassword(uid, encodedOldPass, encodedNewPass, newSalt);
            if (code != 1) {
                Asserts.fail(ResultCode.FORBIDDEN);
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("UserService-updatePassword[ uid:" + uid + " message:" + e.getMessage() + "]");
            throw e;
        }
    }

    @Override
    public UserDTO getUserByTel(String tel) {
        User user = userDAO.findUserByTel(tel);
        return DozerUtils.map(user, UserDTO.class);
    }

    @Override
    @Transactional
    public void recharge(long uid, int money) {
        try {
            User user = userDAO.findUserByUid(uid);
            if (user == null) {
                Asserts.notFound();
            }
            user.setBalance(user.getBalance() + money);
            int code = userDAO.updateBalance(uid, user.getBalance());
            if (code != 1) {
                Asserts.fail();
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("UserService-recharge[ uid:" + uid + " money:" + money +  " message:" + e.getMessage() + "]");
            throw e;
        }
    }
}
