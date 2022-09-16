package com.datawisher.bee.common.core.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author h407644
 * @date 2022-09-16
 */
@Configuration
public class BeeWebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","OPTIONS","DELETE")
                .maxAge(168000)
                .allowedHeaders("*")
                // 是否发送cookie
                .allowCredentials(true);
    }
}
