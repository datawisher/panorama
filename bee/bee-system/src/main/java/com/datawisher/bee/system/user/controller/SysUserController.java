package com.datawisher.bee.system.user.controller;

import com.datawisher.bee.common.model.dto.Result;
import com.datawisher.bee.system.user.entity.SysUser;
import com.datawisher.bee.system.user.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jim Han
 * @since 2022-09-10
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/")
    public Result<List<SysUser>> findAllSysUser() {
        List<SysUser> sysUserList = sysUserService.list();
        return Result.ok(sysUserList);
    }
}
