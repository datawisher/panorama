package cn.datawisher.cyder.system.login.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson2.JSONObject;

import cn.datawisher.cyder.dto.Result;
import cn.datawisher.cyder.system.login.dto.LoginDTO;
import cn.datawisher.cyder.system.login.service.LoginService;

/**
 * 登录service实现类
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
