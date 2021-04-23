package com.datawisher.spring.boot.mybatisplus;

import com.datawisher.spring.boot.mybatisplus.entity.DataType;
import com.datawisher.spring.boot.mybatisplus.entity.IdentityDemo;
import com.datawisher.spring.boot.mybatisplus.entity.SysUser;
import com.datawisher.spring.boot.mybatisplus.mapper.DataTypeMapper;
import com.datawisher.spring.boot.mybatisplus.mapper.IdentityDemoMapper;
import com.datawisher.spring.boot.mybatisplus.mapper.SysUserMapper;
import com.datawisher.spring.boot.mybatisplus.service.IDataTypeService;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private IdentityDemoMapper identityDemoMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testList() {
        List<DataType> list = dataTypeService.list();
        Assert.assertEquals(2, list.size());
        list.forEach(System.out::println);
    }

    @Test
    public void testSelect() {
        List<DataType> personList = dataTypeMapper.selectList(null);
        Assert.assertEquals(2, personList.size());
        personList.forEach(System.out::println);
    }

    @Test
    public void testInsertIdentityDemo() {
        IdentityDemo identityDemo = new IdentityDemo();
        identityDemo.setDescription("insert record xxx");
        int insert = identityDemoMapper.insert(identityDemo);
        System.out.println("--- testInsertIdentityDemo: ---" + insert);
    }

    @Test
    public void testSysUserSelectByIDFromDifferentDB() {
        List<Map<String, Object>> stringObjectMap = sysUserMapper.selectByIdFromDifferentDB();
        System.out.println("stringObjectMap = " + stringObjectMap);
    }

    @Test
    public void testSelectDifferentColumnFromDifferentDB() {
        List<Map<String, Object>> maps = sysUserMapper.selectDifferentColumnFromDifferentDB();
        System.out.println("maps = " + maps);
    }
}
