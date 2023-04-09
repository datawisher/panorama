package cn.datawisher.cyder.stock.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {

    @JsonProperty("request_id")
    private String requestId;
    private Integer code;
    private String msg;
    private Datas data;

    @Getter
    @Setter
    public class Datas {
        private String[] fields;
        private Set<String[]> items;
    }
}
