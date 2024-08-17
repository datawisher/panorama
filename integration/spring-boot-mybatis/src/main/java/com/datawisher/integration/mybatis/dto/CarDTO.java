package com.datawisher.integration.mybatis.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CarDTO {

    private Long id;
    private String carNum;
    private String brand;
    private Double guidePrice;
    private LocalDateTime produceTime;
    private Integer carType;
    private CarTypeDTO carTypeDTO;
}
