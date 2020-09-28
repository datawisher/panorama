package com.datawisher.spring.cloud.feign.consumer.service;

import com.datawisher.spring.cloud.feign.consumer.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "spring-cloud-feign-provider")
public interface PersonFeignService {

    @GetMapping(value = "/person/add")
    String addPerson(@SpringQueryMap Person person);

    @PostMapping("/person/update")
    String updatePerson(@RequestBody Person person);

}
