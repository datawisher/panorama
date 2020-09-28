package com.datawisher.spring.cloud.feign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Jim Han
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringCloudFeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignConsumerApplication.class, args);
    }
}
