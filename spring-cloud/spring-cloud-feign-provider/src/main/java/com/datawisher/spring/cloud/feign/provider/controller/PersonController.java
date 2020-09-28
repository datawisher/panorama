package com.datawisher.spring.cloud.feign.provider.controller;

import com.datawisher.spring.cloud.feign.provider.model.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/person")
public class PersonController {

	@RequestMapping(value = "/add")
	public String addPerson(Person person) {
		return "hello, add "+person.getName();
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePerson( @RequestBody Person person){
		return "hello, update "+person.getName();
	}


}
