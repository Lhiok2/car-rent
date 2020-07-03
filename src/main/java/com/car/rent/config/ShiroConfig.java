package com.car.rent.config;

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

    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(securityManager);

        /*
        * 拦截
        * anon: 所有人都可以访问
        * authc: 必须认证才能访问
        * user: 必须拥有 记住我 功能才能用
        * perms: 拥有对某个资源的权限才能访问
        * role: 拥有某个角色权限才能访问
        * */
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/api/v*/security/**", "anon");
        bean.setFilterChainDefinitionMap(filterMap);

        // 设置登录的请求路径
        bean.setLoginUrl("/toLogin");
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
        return new UserRealm();
    }
}
