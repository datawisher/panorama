package com.datawisher.spring.boot.web.domain.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PersonVo extends PageVo {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    @NotBlank(message = "一定要填东西")
    private String name;

    @JsonProperty("order_by")
    private String orderBy;
}
