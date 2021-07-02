package cn.datawisher.bee.upms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author h407644
 * @date 2021-06-22
 */
@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 部门ID
     */
    @ApiModelProperty(value = "用户所属部门id")
    private Integer deptId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 邮件
     */
    @ApiModelProperty(value = "邮件")
    private String email;

    /**
     * 证件类型
     */
    @ApiModelProperty(value = "证件类型")
    private String cardType;

    /**
     * 证件号码
     */
    @ApiModelProperty(value = "证件号码")
    private String cardNo;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String address;

    /**
     * 账户是否过期
     */
    @ApiModelProperty(value = "账户是否过期")
    private boolean accountNonExpired;

    /**
     * 账户是否锁定
     */
    @ApiModelProperty(value = "账户是否锁定")
    private boolean accountNonLocked;

    /**
     * 密码是否过期
     */
    @ApiModelProperty(value = "密码是否过期")
    private boolean credentialsNonExpired;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "账户是否启用")
    private boolean enabled;
}
