package cn.datawisher.bee.upms.controller;

import cn.datawisher.bee.base.security.annotation.Inner;
import cn.datawisher.bee.base.security.util.SecurityUtils;
import cn.datawisher.bee.upms.entity.SysUser;
import cn.datawisher.bee.upms.service.SysUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author h407644
 * @date 2021-06-25
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Api(value = "user", tags = "用户管理模块")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 获取当前用户全部信息
     * @return 用户信息
     */
    @GetMapping(value = { "/info" })
    public R info() {
        String username = SecurityUtils.getUser().getUsername();
        SysUser user = sysUserService.getOne(
                Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username));
        if (user == null) {
            return R.failed("获取当前用户信息失败");
        }
        return R.ok(sysUserService.getUserInfo(user));
    }

    /**
     * 获取指定用户全部信息
     * @return 用户信息
     */
    @Inner
    @GetMapping("/info/{username}")
    public R info(@PathVariable String username) {
        SysUser user = sysUserService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username));
        if (user == null) {
            return R.failed(String.format("用户信息为空 %s", username));
        }
        return R.ok(sysUserService.getUserInfo(user));
    }


}
