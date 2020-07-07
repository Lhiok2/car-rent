package com.car.rent.config;

import com.car.rent.constant.Identity;
import com.car.rent.utils.PassUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author nayix
 * @date 2020/7/3 17:17
 */
@Configuration
public class ShiroConfig {

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(securityManager);
        // 设置登录的请求路径
        bean.setLoginUrl("/views/security/toLogin");

        /*
        * 拦截
        * anon: 所有人都可以访问
        * authc: 必须认证才能访问
        * user: 必须拥有 记住我 功能才能用
        * perms: 拥有对某个资源的权限才能访问
        * roles: 拥有某个角色权限才能访问
        * */
        Map<String, String> filterMap = new LinkedHashMap<>();
        // 对静态资源设置匿名访问
        filterMap.put("/css/**", "anon");
        filterMap.put("/bootstrap/**", "anon");
        filterMap.put("/fonts/**", "anon");
        filterMap.put("/font-awesome/**", "anon");
        filterMap.put("/images/**", "anon");
        filterMap.put("/img/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/layer/**", "anon");
        filterMap.put("/ico/**", "anon");
        // 不需要拦截的访问
        filterMap.put("/api/v*/security/**", "anon");
        filterMap.put("/views/security/**", "anon");
        // 管理员能够访问的资源
        filterMap.put("/api/v*/cars/admin/**", "roles[" + Identity.ADMIN.getIdentity() + "]");
        filterMap.put("/views/admin/**", "roles[" + Identity.ADMIN.getIdentity() + "]");
        // 所有其他资源都需要用户身份
        filterMap.put("/**", "roles[" + Identity.USER.getIdentity() + "]");
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建realm对象
     */
    @Bean(name = "userRealm")
    public UserRealm getUserRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(getHashedCredentialsMatcher());
        return userRealm;
    }

    /**
     * 对密码进行MD5编码
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher getHashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(PassUtils.HASH_ITERATIONS);
        credentialsMatcher.setStoredCredentialsHexEncoded(false);
        return credentialsMatcher;
    }
}
