package com.datawisher.bee.auth.client;

import com.datawisher.bee.common.model.dto.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author h407644
 * @date 2022-10-30
 */
@FeignClient(name = "bee-system")
public interface SysUserClient {

    @GetMapping("/user")
    Result<?> findSysUserByPage(@RequestParam Map<String, Object> sysUser,
                                @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize);
}
