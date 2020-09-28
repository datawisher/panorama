package com.datawisher.spring.boot.web;

import java.sql.Connection;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jim Han
 */
@SpringBootApplication
public class SpringBootWebApplication implements CommandLineRunner {

    @Autowired
    private DataSource datasource;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Connection connection = datasource.getConnection();
        connection.close();
    }
}
