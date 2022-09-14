package com.datawisher.bee.common.model.dto;

import com.datawisher.bee.common.model.constant.StatusCode;
import com.datawisher.bee.common.model.util.MessageUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 接口返回对象
 * @author Jim Han
 * @date 2021-08-03
 */
@Data
@ApiModel(value="接口返回对象", description="接口返回对象")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    @ApiModelProperty(value = "成功标志")
    private boolean success = true;

    /**
     * 返回处理消息
     */
    @ApiModelProperty(value = "返回处理消息")
    private String message = "操作成功！";

    /**
     * 返回代码
     */
    @ApiModelProperty(value = "返回代码")
    private Integer code = 0;

    /**
     * 返回数据对象 data
     */
    @ApiModelProperty(value = "返回数据对象")
    private T data;

    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();

    public Result() {

    }

    public static<T> Result<T> ok() {
        return ok(null);
    }

    public static<T> Result<T> ok(T data) {
        return ok(StatusCode.OK, data);
    }

    public static<T> Result<T> ok(StatusCode code, T data) {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(code.getCode());
        r.setMessage(MessageUtils.getMsg(code));
        r.setData(data);
        return r;
    }

    public static<T> Result<T> error() {
        return error(StatusCode.ERROR);
    }

    public static<T> Result<T> error(StatusCode code) {
        Result<T> r = new Result<>();
        r.setCode(code.getCode());
        r.setMessage(MessageUtils.getMsg(code));
        r.setSuccess(false);
        return r;
    }

}
