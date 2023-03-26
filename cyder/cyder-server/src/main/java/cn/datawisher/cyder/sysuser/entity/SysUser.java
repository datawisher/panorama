package cn.datawisher.cyder.sysuser.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author Jim Han
 * @since 2023-03-24
 */
@Getter
@Setter
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String realName;

    private LocalDate birthday;

    private String address;

    private String phoneNumber;

    private byte[] avatar;

    private Integer deleteStatus;

    private LocalDateTime lastLogin;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
