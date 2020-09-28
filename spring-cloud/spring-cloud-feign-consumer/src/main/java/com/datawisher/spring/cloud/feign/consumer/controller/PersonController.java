package com.datawisher.spring.cloud.feign.consumer.controller;

import com.datawisher.spring.cloud.feign.consumer.model.Person;
import com.datawisher.spring.cloud.feign.consumer.service.PersonFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonFeignService personFeignService;

	/**
	 * 用于演示Feign的Get请求多参数传递
	 * @param person
	 * @return
	 */
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String addPerson(@RequestBody Person person) {
		return personFeignService.addPerson(person);
	}

	/**
	 * 用于演示Feign的Post请求多参数传递
	 * @param person
	 * @return
	 */
	@PostMapping("/update")
	public String updatePerson(@RequestBody Person person) {
		return personFeignService.updatePerson(person);
	}
}
