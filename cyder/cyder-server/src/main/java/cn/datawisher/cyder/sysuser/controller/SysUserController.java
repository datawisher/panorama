package cn.datawisher.cyder.sysuser.controller;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.datawisher.cyder.sysuser.dto.SysUserDTO;
import cn.datawisher.cyder.sysuser.entity.SysUser;
import cn.datawisher.cyder.sysuser.mapper.SysUserMapper;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Jim Han
 * @since 2023-03-24
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private SysUserMapper mapper;

    @GetMapping("/list")
    public Page<SysUser> findSysUserByPage(Page<SysUser> page, SysUserDTO params) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(params, sysUser);
        return mapper.selectPage(page, Wrappers.query(sysUser)
                .like(params.getUsernameLikeQuery() != null, "username", params.getUsernameLikeQuery())
                .like(params.getRealNameLikeQuery() != null, "real_name", params.getRealNameLikeQuery()));
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
