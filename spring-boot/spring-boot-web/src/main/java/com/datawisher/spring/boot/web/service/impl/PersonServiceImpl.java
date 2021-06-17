package com.datawisher.spring.boot.web.service.impl;

import com.datawisher.spring.boot.web.dao.PersonDao;
import com.datawisher.spring.boot.web.domain.entity.Person;
import com.datawisher.spring.boot.web.service.PersonService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Jim Han
 **/
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    @Override
    public List<Person> getAllPerson() {
        return personDao.selectAllPerson();
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    @Override
    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    @Override
    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePerson(id, newPerson);
    }

    @Override
    public List<Person> getPersonByPage(int offset, int limit) {
        return personDao.selectPersonByPage(offset, limit);
    }

    @Override
    public List<Person> getPersonByPageAndSort(int offset, int limit, String sort) {
        return personDao.selectPersonByPageAndSort(offset, limit, sort);
    }

    //TODO 批量新增
    //TODO 批量修改
    //TODO 批量删除
}
