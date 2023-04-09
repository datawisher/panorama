package cn.datawisher.cyder.stock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO<T> {

    @JsonProperty("api_name")
    private String apiName;

    @JsonProperty("token")
    private String token;

    @JsonProperty("params")
    private T params;

    @JsonProperty("fields")
    private String fields;

    public RequestDTO(T params) {
        this.params = params;
    }
}
