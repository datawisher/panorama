package com.datawisher.bee.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author Jim Han
 * @since 2022-09-12
 */
@Data
@ApiModel(value = "SysUserDTO对象", description = "系统用户DTO")
public class SysUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("盐")
    private String salt;

    @ApiModelProperty("姓名")
    private String realname;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机")
    private String mobile;

    @ApiModelProperty("账号状态(1:正常2:锁定3:首次注册)")
    private String status;

    @ApiModelProperty("已登录部门")
    private String deptCode;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改人")
    private String updateBy;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("删除标记")
    private String delFlag;
}
