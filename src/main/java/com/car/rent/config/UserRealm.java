package com.car.rent.config;

import com.car.rent.vo.UserVO;
import com.car.rent.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

import static com.car.rent.constant.Identity.*;

/**
 * @author nayix
 * @date 2020/7/3 17:18
 */
public class UserRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subjects = SecurityUtils.getSubject();
        UserVO currentUser = (UserVO) subjects.getPrincipal();
        if (hasUserRole(currentUser)) {
            info.addRole(USER.getIdentity());
            if (hasAdminRole(currentUser)) {
                info.addRole(ADMIN.getIdentity());
            }
        }
        return info;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        // 连接真实数据库
        UserVO userVO = userService.getUserByTel(userToken.getUsername());
        // 密码认证，shiro做
        return new SimpleAuthenticationInfo(userVO,
                userVO.getPassword(),
                ByteSource.Util.bytes(userVO.getSalt()),
                getName());
    }
}
