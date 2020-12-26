package com.datawisher.spring.boot.starter.util;

public class HttpClientUtils {

    public static int sendMsg(String url, String accessKeyId, String accessKeySecret, String msg) {
        //TODO 调用指定url进行请求的业务逻辑
        System.out.println("Http请求，url=" + url + ";accessKeyId=" + accessKeyId + ";accessKeySecret=" + accessKeySecret + ";msg=" + msg);
        return 0;
    }

}
