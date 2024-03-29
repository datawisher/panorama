package com.datawisher.lcdp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author h407644
 * @date 2021-05-28
 */
@Slf4j
@Configuration
public class WebSocketConfig {
    /**
     * 	注入ServerEndpointExporter，
     * 	这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
     *  没有的话会报404
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        log.info("--- websocket endpoint exporter init ---");
        return new ServerEndpointExporter();
    }
}
