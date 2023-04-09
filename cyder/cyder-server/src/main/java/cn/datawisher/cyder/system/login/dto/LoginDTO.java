package cn.datawisher.cyder.system.login.dto;

import lombok.Data;

/**
 * 登录DTO
 */
@Data
public class LoginDTO {

    private String username;
    private String password;
    private String captcha;
}
