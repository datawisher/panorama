package com.datawisher.bee.system.login.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.datawisher.bee.common.model.dto.Result;
import com.datawisher.bee.system.login.LoginDTO;
import com.datawisher.bee.system.login.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author h407644
 * @date 2023-01-15
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public Result<?> login(LoginDTO loginDTO) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", UUID.randomUUID().toString());
        return Result.ok(jsonObject);
    }
}
