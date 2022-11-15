package com.datawisher.bee.auth.controller;

import com.datawisher.bee.auth.client.SysUserClient;
import com.datawisher.bee.common.model.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author h407644
 * @date 2022-10-30
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private SysUserClient sysUserClient;

    @GetMapping("/t1")
    public Result<?> t1(Map<String, Object> sysUserDTO,
                        @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return sysUserClient.findSysUserByPage(sysUserDTO, pageNo, pageSize);
    }
}
