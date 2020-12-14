package com.datawisher.spring.boot.web.dao.impl;

import com.datawisher.spring.boot.web.dao.PersonDao;
import com.datawisher.spring.boot.web.domain.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author Jim Han
 **/
@Repository("fakeDao")
public class PersonDaoImpl implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPerson() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (!personMaybe.isPresent()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person newPerson) {
        return selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id, newPerson.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public List<Person> selectPersonByPage(int offset, int limit) {
        List<Person> persons = selectAllPerson();
        if (persons.size() > 1) {
            if (offset >= persons.size()) {
                offset = persons.size() - 1;
            }
            int lastIndex = offset + limit;
            if (lastIndex > persons.size()) {
                lastIndex = persons.size();
            }
            return persons.subList(offset, lastIndex);
        }
        return persons;
    }

    @Override
    public List<Person> selectPersonByPageAndSort(int offset, int limit, String sort) {
        List<Person> persons = selectAllPerson();
        List<Person> sortPersons = new ArrayList<>(persons);
        if (StringUtils.isNotBlank(sort) && "name".equals(sort)) {
            sortPersons.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        }
        if (sortPersons.size() > 1) {
            if (offset >= sortPersons.size()) {
                offset = sortPersons.size() - 1;
            }
            int lastIndex = offset + limit;
            if (lastIndex > sortPersons.size()) {
                lastIndex = sortPersons.size();
            }
            return sortPersons.subList(offset, lastIndex);
        }
        return sortPersons;
    }
}
