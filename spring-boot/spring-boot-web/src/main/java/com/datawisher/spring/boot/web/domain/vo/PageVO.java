package com.datawisher.spring.boot.web.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PageVO {

    @JsonProperty("offset")
    private int offset;

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("sort")
    private String sort;
}
