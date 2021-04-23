package com.datawisher.spring.boot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datawisher.spring.boot.mybatisplus.entity.SysUser;
import com.datawisher.spring.boot.mybatisplus.mapper.SysUserMapper;
import com.datawisher.spring.boot.mybatisplus.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jim Han
 * @since 2021-03-13
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
