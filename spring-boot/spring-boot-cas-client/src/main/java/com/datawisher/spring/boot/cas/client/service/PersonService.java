package com.datawisher.spring.boot.cas.client.service;

import com.datawisher.spring.boot.cas.client.dao.PersonDao;
import com.datawisher.spring.boot.cas.client.model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

    public int addPerson(Person person) {
        return personDao.addPerson(person);
    }

    public int updatePerson(Person person) {
        return personDao.updatePerson(person);
    }

    public int deletePersonById(Long id) {
        return personDao.deletePersonById(id);
    }

    public Person getPersonById(Long id) {
        return personDao.getPersonById(id);
    }

    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }
}
