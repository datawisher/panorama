package com.datawisher.spring.boot.session;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author h407644
 * @date 2021-06-17
 */
@RestController
@SpringBootTest
public class SpringBootSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSessionApplication.class, args);
    }

    @Value("${server.port}")
    Integer port;

    @GetMapping("/set")
    public String set(HttpSession session) {
        session.setAttribute("user", "jimhan");
        return String.valueOf(port);
    }

    @GetMapping("/get")
    public String get(HttpSession session) {
        return session.getAttribute("user") + ":" + port;
    }

}
