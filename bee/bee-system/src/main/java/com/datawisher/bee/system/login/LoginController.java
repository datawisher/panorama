package com.datawisher.bee.system.login;

import com.datawisher.bee.common.model.dto.Result;
import com.datawisher.bee.system.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author h407644
 * @date 2023-01-15
 */
@RestController
@RequestMapping("/api/sys/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result<?> login(LoginDTO loginDTO) {
        Result<?> result = loginService.login(loginDTO);
        return result;
    }
}
