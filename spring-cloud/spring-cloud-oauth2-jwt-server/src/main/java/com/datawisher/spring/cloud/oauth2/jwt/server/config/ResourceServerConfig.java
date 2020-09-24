package com.datawisher.spring.cloud.oauth2.jwt.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源服务器配置
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .requestMatchers()
                .antMatchers("/user/**");//表示该安全规则只针对参数指定的路径进行过滤,因为测试没有前端代码，先这样去做

        /**
         * (1)HttpSecurity.antMatcher(...)表示该安全规则只针对参数指定的路径进行过滤
         * (2)HttpSecurity.requestMatchers同上，唯一区别是可以接受多个参数【两者不能同时使用】
         * (3)HttpSecurity.authorizeRequests()该方法用于配置权限，如hasAnyRole、access(...)
         * (4).authorizeRequests().anyRequest()除去已经配置了的路径之外的其他路径，即包含在(1)/(2)中不包含在HttpSecurity.authorizeRequests().antMatchers(…)中的其他路径
         */
    }
}
