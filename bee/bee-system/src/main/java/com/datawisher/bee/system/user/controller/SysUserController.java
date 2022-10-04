package com.datawisher.bee.system.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.datawisher.bee.common.model.constant.StatusCode;
import com.datawisher.bee.common.model.dto.Result;
import com.datawisher.bee.common.model.exception.SystemException;
import com.datawisher.bee.system.user.entity.SysUser;
import com.datawisher.bee.system.user.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Jim Han
 * @since 2022-09-10
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping
    @ApiOperation(value = "用户分页查询")
    public Result<?> findSysUserByPage(SysUser sysUser,
                                    @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<SysUser> page = new Page<>(pageNo, pageSize);
        IPage<SysUser> result = sysUserService.page(page, Wrappers.query(sysUser));
        return Result.ok(result);
    }

    @PostMapping
    @ApiOperation(value = "用户新增")
    public Result<?> addSysUser(@RequestBody SysUser sysUser) throws SystemException {
        try {
            boolean result = sysUserService.save(sysUser);
            return result ? Result.ok(StatusCode.USER_ADD_SUCCESS, null) : Result.error(StatusCode.USER_ADD_ERROR);
        } catch (Exception e) {
            throw new SystemException(StatusCode.USER_ADD_ERROR, e);
        }
    }

    @PutMapping
    @ApiOperation(value = "用户编辑")
    public Result<?> editSysUserById(@RequestBody SysUser sysUser) throws SystemException {
        boolean result;
        try {
            result = sysUserService.updateById(sysUser);
            return result ? Result.ok(StatusCode.USER_EDIT_SUCCESS, null) : Result.error(StatusCode.USER_EDIT_ERROR);
        } catch (Exception e) {
            throw new SystemException(StatusCode.USER_EDIT_ERROR, e);
        }
    }

    @DeleteMapping
    @ApiOperation(value = "用户删除")
    public Result<?> removeSysUserById(@RequestBody SysUser sysUser) throws SystemException {
        try {
            boolean result = sysUserService.removeById(sysUser);
            return result ? Result.ok(StatusCode.USER_DELETE_SUCCESS, null) : Result.error(StatusCode.USER_DELETE_ERROR);
        } catch (Exception e) {
            throw new SystemException(StatusCode.USER_DELETE_ERROR, e);
        }
    }

    @DeleteMapping("/batch")
    @ApiOperation(value = "用户批量删除")
    public Result<?> batchRemoveSysUserByIds(@RequestBody List<String> ids) throws SystemException {
        try {
            boolean result = sysUserService.removeBatchByIds(ids, 50);
            return result ? Result.ok(StatusCode.USER_BATCH_DELETE_SUCCESS, null) : Result.error(StatusCode.USER_BATCH_DELETE_ERROR);
        } catch (Exception e) {
            throw new SystemException(StatusCode.USER_BATCH_DELETE_ERROR, e);
        }
    }

}
