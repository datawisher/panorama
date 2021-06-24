package cn.datawisher.bee.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author h407644
 * @date 2021-06-21
 */
@SpringBootApplication(scanBasePackages = {
        "cn.datawisher.bee.auth",
        "cn.datawisher.bee.base"})
@EnableDiscoveryClient
public class BeeAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeeAuthApplication.class, args);
    }

}
