package com.car.rent.repository;

import com.car.rent.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nayix
 * @date 2020/6/28 20:09
 */
public interface UserRepository extends CrudRepository<User, Long> {
    /**
     * 通过id获取用户MD5盐
     * @param uid
     * @return
     */
    @Query("select salt from User where uid = :uid")
    String getSaltByUid(@Param("uid") long uid);

    /**
     * 通过tel获取用户MD5盐
     * @param tel
     * @return
     */
    @Query("select salt from User where tel = :tel")
    String getSaltByTel(@Param("tel") String tel);

    /**
     * 查询手机号是否被注册
     * @param tel
     * @return
     */
    boolean existsByTel(String tel);

    /**
     * 通过tel查询用户
     * @param tel
     * @return
     */
    User findUserByTel(String tel);

    /**
     * 通过id获取user
     * @param uid
     * @return
     */
    User findUserByUid(long uid);

    /**
     * 通过手机号和密码删除用户
     * @param tel
     * @param password
     * @return
     */
    @Modifying
    @Transactional
    @Query("delete from User where tel = :tel and password = :password")
    int deleteByTelAndPassword(@Param("tel") String tel, @Param("password") String password);

    /**
     * 通过id更新余额
     * @param uid
     * @param balance
     * @return
     */
    @Modifying
    @Transactional
    @Query("update User set balance = :balance where uid = :uid")
    int updateBalance(long uid, long balance);

    /**
     * 通过手机号更改用户名
     * @param uid
     * @param username
     * @return
     */
    @Modifying
    @Transactional
    @Query("update User set username = :username where uid = :uid")
    int updateUsername(@Param("uid") long uid, @Param("username") String username);

    /**
     * 通过id和旧密码更改密码
     * @param uid
     * @param oldPass
     * @param newPass
     * @param newSalt
     * @return
     */
    @Modifying
    @Transactional
    @Query("update User set password = :newPass, salt = :newSalt where uid = :uid and password = :oldPass")
    int updatePassword(@Param("uid") long uid, @Param("oldPass") String oldPass, @Param("newPass") String newPass, @Param("newSalt") String newSalt);
}
