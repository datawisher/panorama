package com.datawisher.integration.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.datawisher.integration.mybatis.dto.CarDTO;
import com.datawisher.integration.mybatis.po.Car;

@Mapper
public interface CarMapper {

    /**
     * 查询所有汽车
     *
     * @return
     */
    List<Car> getAll();

    /**
     * 查询所有汽车
     *
     * @return
     */
    @Select("select * from t_car")
    List<Car> getAll2();

    /**
     * 查询所有汽车
     *
     * @return
     */
    List<CarDTO> getAll3();

    /**
     * 查询所有汽车
     *
     * @return
     */
    List<CarDTO> getAll4();
}
