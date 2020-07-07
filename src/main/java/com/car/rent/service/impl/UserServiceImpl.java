package com.car.rent.service.impl;

import com.car.rent.exception.ApiException;
import com.car.rent.repository.UserRepository;
import com.car.rent.vo.UserVO;
import com.car.rent.domain.User;
import com.car.rent.constant.Identity;
import com.car.rent.constant.response.ResultCode;
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
    private UserRepository userRepository;

    @Transactional
    @Override
    public void addUser(String username, String tel, String password) {
        if (userRepository.existsByTel(tel)) {
            throw new ApiException(ResultCode.REPEAT_TEL);
        }
        String salt = getRandomSalt();
        String encodedPass = getEncodedPass(password, salt);
        try {
            userRepository.save(User.builder()
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
            String salt = userRepository.getSaltByTel(tel);
            String encodedPass = getEncodedPass(password, salt);
            int code = userRepository.deleteByTelAndPassword(tel, encodedPass);
            if (code != 1) {
                Asserts.fail(ResultCode.WRONG_PASS);
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
            int code = userRepository.updateUsername(uid, username);
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
            String oldSalt = userRepository.getSaltByUid(uid);
            String encodedOldPass = getEncodedPass(oldPass, oldSalt);
            String newSalt = getRandomSalt();
            String encodedNewPass = getEncodedPass(newPass, newSalt);
            int code = userRepository.updatePassword(uid, encodedOldPass, encodedNewPass, newSalt);
            if (code != 1) {
                Asserts.fail(ResultCode.WRONG_PASS);
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("UserService-updatePassword[ uid:" + uid + " message:" + e.getMessage() + "]");
            throw e;
        }
    }

    @Override
    public UserVO getUserByTel(String tel) {
        User user = userRepository.findUserByTel(tel);
        return DozerUtils.map(user, UserVO.class);
    }

    @Override
    public UserVO getUserByUid(long uid) {
        User user = userRepository.findUserByUid(uid);
        return DozerUtils.map(user, UserVO.class);
    }

    @Override
    @Transactional
    public void recharge(long uid, int money) {
        try {
            User user = userRepository.findUserByUid(uid);
            if (user == null) {
                Asserts.notFound();
            }
            user.setBalance(user.getBalance() + money);
            int code = userRepository.updateBalance(uid, user.getBalance());
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
