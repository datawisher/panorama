package cn.datawisher.bee.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author h407644
 * @date 2021-06-23
 */
@SpringBootApplication
public class BeeAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeeAdminApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
