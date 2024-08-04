package com.datawisher.integration.webservice.server.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(
        name = "MyWebService",
        targetNamespace = "http://datawisher.cn/mywebservice"
)
public interface MyWebService {

    @WebMethod
    String sayHello(String name);
}
