package com.datawisher.spring.boot.druid.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author Jim Han
 */
@Data
@Builder
public class ResponseResult<T> {

    /**
     * 响应code
     */
    @JsonProperty
    private int code;
    /**
     * 响应信息
     */
    @JsonProperty
    private String msg;
    /**
     * 操作成功，响应数据
     */
    @JsonProperty
    private T data;

    public ResponseResult<T> ok(T data) {
        return new ResponseResult<T>(CodeType.OK.getCode(), "", data);
    }
}
