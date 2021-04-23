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
 * @since 2021-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SYS_PRIVILEGE")
public class SysPrivilege implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @TableField("PRIVILEGE_NAME")
    private String privilegeName;

    @TableField("PRIVILEGE_URL")
    private String privilegeUrl;


}
