package com.datawisher.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author h407644
 * @date 2022-06-07
 */
@SpringBootApplication
public class SpringBoot270ServletApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBoot270ServletApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot270ServletApplication.class, args);
    }


}
