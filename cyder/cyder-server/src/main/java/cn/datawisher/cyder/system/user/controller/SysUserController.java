package cn.datawisher.cyder.system.user.controller;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.datawisher.cyder.dto.Result;
import cn.datawisher.cyder.system.user.dto.SysUserDTO;
import cn.datawisher.cyder.system.user.entity.SysUser;
import cn.datawisher.cyder.system.user.mapper.SysUserMapper;
import cn.datawisher.cyder.system.user.service.ISysUserService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Jim Han
 * @since 2023-03-24
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private SysUserMapper mapper;

    @GetMapping("/page")
    public Page<SysUser> findSysUserByPage(Page<SysUser> page, SysUserDTO params) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(params, sysUser);
        return mapper.selectPage(page, null);
    }

    @GetMapping("/{id}")
    public Result<?> getSysUserById(@PathVariable Long id) {
        SysUser entityById = sysUserService.getEntityById(id);
        return Result.ok(entityById);
    }

    @PostMapping("/delete")
    public void removeSysUserById(@RequestBody Serializable id) {
        mapper.deleteById(id);
    }

    @PostMapping("/update")
    public void editSysUser(@RequestBody SysUserDTO params) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(params, sysUser);
        mapper.updateById(sysUser);
    }
}
