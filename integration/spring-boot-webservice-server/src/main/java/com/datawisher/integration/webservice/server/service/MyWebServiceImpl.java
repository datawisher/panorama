package com.datawisher.integration.webservice.server.service;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service
@WebService
public class MyWebServiceImpl implements MyWebService {


    @Override
    public String sayHello(String name) {

        System.err.println("sayHello is called..."); // 只是为了更明显的输出，采用err
        return "Hello, " + name + "!";
    }
}
