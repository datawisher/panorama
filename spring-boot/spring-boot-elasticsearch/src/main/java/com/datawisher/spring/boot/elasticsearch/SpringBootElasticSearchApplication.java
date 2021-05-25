package com.datawisher.spring.boot.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootElasticSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElasticSearchApplication.class, args);
    }

    /*@Bean
    public TransportClient transportClient() throws UnknownHostException {
        TransportClient client = new PreBuiltXPackTransportClient(Settings.builder()
                .put("cluster.name", "elasticsearch")
                .put("xpack.security.user", "elastic:reOOzRfUE4UqBuQQAi16")
                .put("xpack.security.transport.ssl.enabled", "true")
                .build())
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        return client;
    }*/
}
