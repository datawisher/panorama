package cn.datawisher.cyder.system.user.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import cn.datawisher.cyder.system.user.constant.AccountStatusEnum;
import cn.datawisher.cyder.system.user.constant.SexEnum;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author Jim Han
 * @since 2023-03-24
 */
@Data
public class SysUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private String salt;

    private String realname;

    private SexEnum sex;

    private String avatar;

    private String email;

    private String mobile;

    private AccountStatusEnum status;

    private String deptCode;

    private Long createBy;

    private LocalDateTime createTime;

    private Long updateBy;

    private LocalDateTime updateTime;

    private Long tenantId;

    private Boolean delFlag;

}
