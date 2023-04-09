package cn.datawisher.cyder.system.login.service;


import cn.datawisher.cyder.dto.Result;
import cn.datawisher.cyder.system.login.dto.LoginDTO;

/**
 * 登录Service接口
 */
public interface LoginService {

    Result<?> login(LoginDTO loginDTO);
}
