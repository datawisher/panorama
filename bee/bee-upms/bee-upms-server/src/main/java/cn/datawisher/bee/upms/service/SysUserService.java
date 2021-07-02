package cn.datawisher.bee.upms.service;

import cn.datawisher.bee.upms.dto.UserInfo;
import cn.datawisher.bee.upms.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author h407644
 * @date 2021-06-25
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 查询用户信息
     * @param sysUser 用户
     * @return userInfo
     */
    UserInfo getUserInfo(SysUser sysUser);

}
