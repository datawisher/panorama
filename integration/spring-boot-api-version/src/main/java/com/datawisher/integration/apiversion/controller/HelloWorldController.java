package com.datawisher.integration.apiversion.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class HelloWorldController {
    //@GetMapping(params = "version=1")
    //@GetMapping(produces = "application/vnd.datawisher.app.v1+json")
    @GetMapping(headers = "X-API-VERSION=1")
    public Map<String, Object> showHelloWorldV1() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Hello World V1");
        return map;
    }

    //@GetMapping(params = "version=2")
    //@GetMapping(produces = "application/vnd.datawisher.app.v2+json")
    @GetMapping(headers = "X-API-VERSION=2")
    public Map<String, Object> showHelloWorldV2() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Hello World V2");
        return map;
    }
}
