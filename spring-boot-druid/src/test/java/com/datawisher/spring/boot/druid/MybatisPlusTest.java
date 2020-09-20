package com.datawisher.spring.boot.druid;

import com.datawisher.spring.boot.druid.entity.Person;
import com.datawisher.spring.boot.druid.mapper.PersonMapper;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void testSelect() {
        System.out.println("--------- selectAll method test -------------");
        List<Person> personList = personMapper.selectList(null);
        Assert.assertEquals(10, personList.size());
    }
}
