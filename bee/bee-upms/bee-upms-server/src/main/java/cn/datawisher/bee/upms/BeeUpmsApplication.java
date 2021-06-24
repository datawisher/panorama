package cn.datawisher.bee.upms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author h407644
 * @date 2021-06-21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BeeUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeeUpmsApplication.class, args);
    }
}
