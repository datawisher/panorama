package com.datawisher.spring.boot.cas.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author h407644
 * @date 2021-05-25
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        return "word";
    }
}
