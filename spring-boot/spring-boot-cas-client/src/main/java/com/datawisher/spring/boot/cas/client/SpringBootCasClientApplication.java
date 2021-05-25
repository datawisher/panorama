package com.datawisher.spring.boot.cas.client;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jim Han
 */
@SpringBootApplication
@EnableCasClient
public class SpringBootCasClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCasClientApplication.class, args);
    }

}
