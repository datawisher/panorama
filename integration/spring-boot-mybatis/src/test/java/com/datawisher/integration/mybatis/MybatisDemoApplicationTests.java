package com.datawisher.integration.mybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.datawisher.integration.mybatis.dto.CarDTO;
import com.datawisher.integration.mybatis.mapper.CarMapper;
import com.datawisher.integration.mybatis.po.Car;

import cn.hutool.json.JSONUtil;

@SpringBootTest
public class MybatisDemoApplicationTests {

    @Autowired
    private CarMapper carMapper;
    @Test
    public void test() {
        List<Car> all = carMapper.getAll();
        System.err.println(JSONUtil.toJsonStr(all));
    }


    @Test
    public void test2() {
        List<Car> all = carMapper.getAll2();
        System.err.println(JSONUtil.toJsonStr(all));
    }

    @Test
    public void test3() {
        List<CarDTO> all = carMapper.getAll3();
        System.err.println(JSONUtil.toJsonStr(all));
    }

    @Test
    public void test4() {
        List<CarDTO> all = carMapper.getAll4();
        System.err.println(JSONUtil.toJsonStr(all));
    }
}
