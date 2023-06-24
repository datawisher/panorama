package cn.datawisher.cyder.system.user.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.datawisher.cyder.system.user.entity.SysUser;
import cn.datawisher.cyder.system.user.mapper.SysUserMapper;
import cn.datawisher.cyder.system.user.service.ISysUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jim Han
 * @since 2023-03-24
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Cacheable("cache1")
    @Override
    public SysUser getEntityById(Long id) {
        return baseMapper.selectById(id);
    }
}
