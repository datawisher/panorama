package cn.datawisher.cyder.sysuser.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import cn.datawisher.cyder.sysuser.constant.SexEnum;
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

    private String usernameLikeQuery;

    private String password;

    private SexEnum sex;

    private String email;

    private String realName;

    private String realNameLikeQuery;

    private LocalDate birthday;

    private String address;

    private String phoneNumber;

    private byte[] avatar;

    private Integer deleteStatus;

    private LocalDateTime lastLogin;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
