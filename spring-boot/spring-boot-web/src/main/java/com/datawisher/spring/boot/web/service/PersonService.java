package com.datawisher.spring.boot.web.service;

import com.datawisher.spring.boot.web.domain.entity.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Description
 * @Author Jim Han
 **/
public interface PersonService {

    int addPerson(Person person);

    List<Person> getAllPerson();

    Optional<Person> getPersonById(UUID id);

    int deletePerson(UUID id);

    int updatePerson(UUID id, Person newPerson);

    List<Person> getPersonByPage(int offset, int limit);

    List<Person> getPersonByPageAndSort(int offset, int limit, String sort);
}
