package com.datawisher.jdk;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

/**
 * @author h407644
 * @date 2022-07-08
 */
public class StringTest {
    public static void main(String[] args) {
        String ip = "10.10.10.10,127.0.0.1";
        if (StringUtils.isNotBlank(ip)) {
            String[] split = ip.split(",");
            System.err.println(split[0]);
        }
    }
}
