package com.datawisher.integration.mybatis.po;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Car {

    private Long id;
    private String carNum;
    private String brand;
    private Double guidePrice;
    private LocalDateTime produceTime;
    private Integer carType;

}
