package com.datawisher.spring.boot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datawisher.spring.boot.mybatisplus.entity.SysRole;
import com.datawisher.spring.boot.mybatisplus.mapper.SysRoleMapper;
import com.datawisher.spring.boot.mybatisplus.service.ISysRoleService;
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
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

}
