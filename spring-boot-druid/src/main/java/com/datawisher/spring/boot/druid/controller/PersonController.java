package com.datawisher.spring.boot.druid.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datawisher.spring.boot.druid.common.CodeType;
import com.datawisher.spring.boot.druid.common.ResponseResult;
import com.datawisher.spring.boot.druid.dto.PersonDTO;
import com.datawisher.spring.boot.druid.entity.Person;
import com.datawisher.spring.boot.druid.service.IPersonService;
import java.io.Serializable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jim Han
 * @since 2020-09-19
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping
    public PersonDTO findPersonById(Long id) {
        Person person = personService.getById(id);
        PersonDTO personDTO = new PersonDTO();
        BeanUtils.copyProperties(person, personDTO);
        return personDTO;
    }

    @GetMapping("/page")
    public ResponseResult<Page<Person>> findPersonByPage(@RequestParam Long size, @RequestParam Long current) {
        Page<Person> page = new Page<>();
        page.setSize(size);
        page.setCurrent(current);
        Page<Person> personPage = personService.page(page);
        return (ResponseResult) ResponseResult.builder().code(CodeType.OK.getCode())
                .data(personPage).build();
    }

    @PostMapping
    public PersonDTO addPerson(@RequestBody Person person) {
        personService.save(person);
        PersonDTO personDTO = new PersonDTO();
        BeanUtils.copyProperties(person, personDTO);
        return personDTO;
    }

    @PutMapping
    public PersonDTO updatePerson(@RequestBody Person person) {
        personService.updateById(person);
        PersonDTO personDTO = new PersonDTO();
        BeanUtils.copyProperties(person, personDTO);
        return personDTO;
    }
}

