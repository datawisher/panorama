package com.datawisher.spring.boot.web.dao;

import com.datawisher.spring.boot.web.domain.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Description
 * @Author Jim Han
 **/
public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPerson();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePerson(UUID id, Person person);
}
