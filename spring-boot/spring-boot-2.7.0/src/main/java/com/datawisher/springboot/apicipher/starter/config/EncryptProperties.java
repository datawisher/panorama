package com.datawisher.springboot.apicipher.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author h407644
 * @date 2022-06-05
 */
@ConfigurationProperties(prefix = "spring.encrypt")
public class EncryptProperties {
    // 16 位字符串密码
    private final static String DEFAULT_KEY = "vukyHqSUHahxL1KO";
    private String key = DEFAULT_KEY;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
