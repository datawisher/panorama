package com.datawisher.springboot.interceptorchain;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author h407644
 * @date 2022-06-18
 */
public class MyController {

    @RequestMapping("/hello")
    String hello(String name){
        System.out.println("-业务处理开始-");
        System.out.println("-业务处理结束-");
        return "hello "+name;
    }
}
