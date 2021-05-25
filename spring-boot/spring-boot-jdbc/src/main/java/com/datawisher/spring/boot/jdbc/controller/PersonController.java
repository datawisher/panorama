package com.datawisher.spring.boot.jdbc.controller;

import com.datawisher.spring.boot.jdbc.model.Person;
import com.datawisher.spring.boot.jdbc.service.PersonService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/person")
    public void personOps() {
        Person p1 = new Person();
        p1.setId((long) UUID.randomUUID().hashCode());
        p1.setName("Tompkins");
        p1.setAge(22);
        int i = personService.addPerson(p1);
        System.out.println("addPerson>>>" + i);
    }
}
