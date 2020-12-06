package com.datawisher.spring.boot.web;

import com.datawisher.spring.boot.web.function.NoRepeat;
import java.sql.Connection;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author Jim Han
 */
@SpringBootApplication(exclude = {RedisRepositoriesAutoConfiguration.class})
public class SpringBootWebApplication implements CommandLineRunner {

    @Autowired
    private DataSource datasource;

    @Autowired
    private NoRepeat noRepeat;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Connection connection = datasource.getConnection();
        connection.close();

        noRepeat.noRepeatByRedis();
    }
}
