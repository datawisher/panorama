package cn.datawisher.bee.upms.service.impl;

import cn.datawisher.bee.upms.dto.UserInfo;
import cn.datawisher.bee.upms.entity.SysUser;
import cn.datawisher.bee.upms.mapper.SysUserMapper;
import cn.datawisher.bee.upms.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author h407644
 * @date 2021-06-25
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public UserInfo getUserInfo(SysUser sysUser) {
        UserInfo userInfo = new UserInfo();
        userInfo.setSysUser(sysUser);
        return userInfo;
    }
}
