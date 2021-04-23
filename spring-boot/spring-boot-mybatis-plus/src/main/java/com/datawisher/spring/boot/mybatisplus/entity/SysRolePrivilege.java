package com.datawisher.spring.boot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("SYS_ROLE_PRIVILEGE")
public class SysRolePrivilege implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("ROLE_ID")
    private Long roleId;

    @TableField("PRIVILEGE_ID")
    private Long privilegeId;


}
