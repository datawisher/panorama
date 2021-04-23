package com.datawisher.spring.boot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Blob;
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
@TableName("SYS_USER")
public class SysUser implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @TableField("USER_NAME")
    private String userName;

    @TableField("USER_PASSWORD")
    private String userPassword;

    @TableField("USER_EMAIL")
    private String userEmail;

    @TableField("USER_INFO")
    private String userInfo;

    @TableField("HEAD_IMG")
    private Blob headImg;

    @TableField("CREATE_TIME")
    private LocalDateTime createTime;


}
