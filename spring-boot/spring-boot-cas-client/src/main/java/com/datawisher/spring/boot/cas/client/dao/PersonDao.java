package com.datawisher.spring.boot.cas.client.dao;

import com.datawisher.spring.boot.cas.client.model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int addPerson(Person person) {
        return jdbcTemplate
                .update("insert into person(id, name, age) values (?, ?, ?)", person.getId(),
                        person.getName(), person.getAge());
    }

    public int updatePerson(Person person) {
        return jdbcTemplate.update("update person set name=?, age=? where id=?", person.getName(),
                person.getAge(), person.getId());
    }

    public int deletePersonById(Long id) {
        return jdbcTemplate.update("delete from person where id=?", id);
    }

    public Person getPersonById(Long id) {
        return jdbcTemplate.queryForObject("select * from person where id=?",
                new BeanPropertyRowMapper<>(Person.class), id);
    }

    public List<Person> getAllPersons() {
        return jdbcTemplate
                .query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }
}
