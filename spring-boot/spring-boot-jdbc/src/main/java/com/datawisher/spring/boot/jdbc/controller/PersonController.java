package com.datawisher.spring.boot.jdbc.controller;

import com.datawisher.spring.boot.jdbc.model.Person;
import com.datawisher.spring.boot.jdbc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    public Person findPerson(@PathVariable("id") Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/add")
    public Integer addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PostMapping("/delete")
    public Integer deletePerson(@RequestBody Person person) {
        return personService.deletePersonById(person.getId());
    }
}
