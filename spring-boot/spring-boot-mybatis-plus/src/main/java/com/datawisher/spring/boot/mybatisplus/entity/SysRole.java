package com.datawisher.spring.boot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("SYS_ROLE")
public class SysRole implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @TableField("ROLE_NAME")
    private String roleName;

    @TableField("ENABLED")
    private Integer enabled;

    @TableField("CREATE_BY")
    private Long createBy;

    @TableField("CREATE_TIME")
    private LocalDateTime createTime;


}
