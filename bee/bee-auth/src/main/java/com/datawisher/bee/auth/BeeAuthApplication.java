package com.datawisher.bee.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author h407644
 * @date 2022-10-04
 */
@SpringBootApplication
@EnableFeignClients
public class BeeAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeeAuthApplication.class, args);
    }
}
