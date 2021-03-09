package com.datawisher.spring.boot.mybatisplus;

import com.datawisher.spring.boot.mybatisplus.entity.DataType;
import com.datawisher.spring.boot.mybatisplus.mapper.DataTypeMapper;
import com.datawisher.spring.boot.mybatisplus.service.IDataTypeService;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private DataTypeMapper dataTypeMapper;

    @Autowired
    private IDataTypeService dataTypeService;

    @Test
    public void testList() {
        List<DataType> list = dataTypeService.list();
        Assert.assertEquals(1, list.size());
        list.forEach(System.out::println);
    }

    @Test
    public void testSelect() {
        List<DataType> personList = dataTypeMapper.selectList(null);
        Assert.assertEquals(1, personList.size());
        personList.forEach(System.out::println);
    }

}
