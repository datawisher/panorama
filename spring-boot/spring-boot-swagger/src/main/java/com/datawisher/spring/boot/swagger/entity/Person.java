package com.datawisher.spring.boot.swagger.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jim Han
 * @since 2020-09-19
 */
@ApiModel(value = "用户实体类", description = "用户信息描述类")
@Data
public class Person implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;


}
