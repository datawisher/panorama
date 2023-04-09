package cn.datawisher.cyder.system.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.datawisher.cyder.dto.Result;
import cn.datawisher.cyder.system.login.dto.LoginDTO;
import cn.datawisher.cyder.system.login.service.LoginService;

/**
 * 系统登录接口
 */
@RestController
@RequestMapping("/sys/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result<?> login(LoginDTO loginDTO) {
        Result<?> result = loginService.login(loginDTO);
        return result;
    }
}
