package cn.datawisher.bee.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author h407644
 * @date 2021-06-23
 */
@SpringBootApplication(scanBasePackages = {
        "cn.datawisher.bee.uaa",
        "cn.datawisher.bee.base"})
@EnableFeignClients("cn.datawisher.bee.upms.feign")
@EnableCaching
public class BeeUaaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeeUaaApplication.class, args);
    }

}
