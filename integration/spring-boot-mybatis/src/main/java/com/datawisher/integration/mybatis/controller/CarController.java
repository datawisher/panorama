package com.datawisher.integration.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datawisher.integration.mybatis.mapper.CarMapper;
import com.datawisher.integration.mybatis.po.Car;

@RestController
public class CarController {

    @Autowired
    private CarMapper carMapper;

    @GetMapping("/find-all")
    public String findAll() {
        List<Car> all = carMapper.getAll();
        return all.toString();
    }
}
