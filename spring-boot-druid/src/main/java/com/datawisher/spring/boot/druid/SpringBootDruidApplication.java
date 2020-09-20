package com.datawisher.spring.boot.druid;

import java.sql.Connection;
import javax.sql.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jim Han
 */
@SpringBootApplication
@MapperScan("com.datawisher.spring.boot.druid.mapper")
public class SpringBootDruidApplication {

    @Autowired
    private DataSource datasource;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDruidApplication.class, args);
    }

    /*@Override
    public void run(String... args) throws Exception {
        Connection connection = datasource.getConnection();
        connection.close();
    }*/
}
