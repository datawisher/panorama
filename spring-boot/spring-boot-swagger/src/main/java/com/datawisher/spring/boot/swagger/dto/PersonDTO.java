package com.datawisher.spring.boot.swagger.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Jim Han
 */
@Data
public class PersonDTO {

    @JsonIgnore
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Integer age;

}
