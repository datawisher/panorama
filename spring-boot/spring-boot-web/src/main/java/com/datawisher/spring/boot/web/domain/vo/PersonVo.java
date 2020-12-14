package com.datawisher.spring.boot.web.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.Data;

@Data
public class PersonVo extends PageVo {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;
}
