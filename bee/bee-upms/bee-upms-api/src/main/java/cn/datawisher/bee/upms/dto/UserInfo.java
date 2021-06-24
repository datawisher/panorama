package cn.datawisher.bee.upms.dto;

import cn.datawisher.bee.upms.entity.SysUser;
import java.io.Serializable;
import lombok.Data;

/**
 * @author h407644
 * @date 2021-06-22
 */
@Data
public class UserInfo implements Serializable {
    /**
     * 用户基本信息
     */
    private SysUser sysUser;

    /**
     * 权限标识集合
     */
    private String[] permissions;

    /**
     * 角色集合
     */
    private Integer[] roles;
}
