package com.datawisher.bee.common.model.dto;

import com.datawisher.bee.common.model.constant.CommonConstant;
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
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(CommonConstant.CODE_OK_0);
        r.setMessage("成功");
        return r;
    }

    public static<T> Result<T> ok(T data) {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(CommonConstant.CODE_OK_0);
        r.setData(data);
        return r;
    }

    public static<T> Result<T> ok(String msg, T data) {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(CommonConstant.CODE_OK_0);
        r.setMessage(msg);
        r.setData(data);
        return r;
    }

    public static<T> Result<T> error(String msg) {
        return error(CommonConstant.CODE_ERROR_1, msg);
    }

    public static<T> Result<T> error(int code, String msg) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

}
