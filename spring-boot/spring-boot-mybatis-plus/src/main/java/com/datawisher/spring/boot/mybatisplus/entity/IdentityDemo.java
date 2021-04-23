package com.datawisher.spring.boot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jim Han
 * @since 2021-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("IDENTITY_DEMO")
public class IdentityDemo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("DESCRIPTION")
    private String description;


}
