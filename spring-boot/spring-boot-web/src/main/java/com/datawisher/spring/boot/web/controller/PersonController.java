package com.datawisher.spring.boot.web.controller;

import com.datawisher.spring.boot.web.domain.entity.Person;
import com.datawisher.spring.boot.web.domain.vo.PersonVO;
import com.datawisher.spring.boot.web.service.PersonService;
import com.datawisher.spring.boot.web.util.JsonUtils;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description Restful
 * @Author h407644
 **/
@Slf4j
@RestController
@RequestMapping("/v1/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping(params = {"offset", "limit"})
    public List<Person> getPersonByPage(HttpServletRequest request, HttpServletResponse response) {
        PersonVO vo = new PersonVO();
        log.info("before bind: " + JsonUtils.toJson(vo));
        ServletRequestDataBinder binder = new ServletRequestDataBinder(vo);
        binder.bind(request);
        log.info("after bind: " + JsonUtils.toJson(vo));

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<PersonVO>> violations = validator.validate(vo);
        for (ConstraintViolation<PersonVO> violation : violations) {
            throw new RuntimeException(violation.getMessage());
        }

        if (StringUtils.isNotBlank(vo.getSort())) {
            return personService.getPersonByPageAndSort(vo.getOffset(), vo.getLimit(), vo.getSort());
        }
        return personService.getPersonByPage(vo.getOffset(), vo.getLimit());
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }

    @GetMapping(params = "{sort}")
    public List<Person> getPersonByMatrixVariable(@MatrixVariable(required = true) String sort) {
        log.info("");
        return null;
    }
}
