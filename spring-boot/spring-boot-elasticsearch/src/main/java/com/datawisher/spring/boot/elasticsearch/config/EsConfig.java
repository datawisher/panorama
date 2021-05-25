//package com.datawisher.spring.boot.elasticsearch.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
///**
// * @author h407644
// * @date 2021-04-27
// */
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.datawisher.spring.boot.elasticsearch.repository")
//@ComponentScan(basePackages = {"com.datawisher.spring.boot.elasticsearch.service"})
//public class EsConfig {
//
//    @Bean
//    public RestHighLevelClient client() {
//        ClientConfiguration clientConfiguration
//                = ClientConfiguration.builder()
//                .connectedTo("localhost:9200")
//                .build();
//
//        return RestClients.create(clientConfiguration).rest();
//    }
//
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() {
//        return new ElasticsearchRestTemplate(client());
//    }
//
//}
