package cn.datawisher.bee.upms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author h407644
 * @date 2021-06-21
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.datawisher.bee.upms.mapper")
public class BeeUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeeUpmsApplication.class, args);
    }
}
