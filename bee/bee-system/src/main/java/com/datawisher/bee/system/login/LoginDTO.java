package com.datawisher.bee.system.login;

import lombok.Data;

/**
 * @author h407644
 * @date 2023-01-15
 */
@Data
public class LoginDTO {

    private String username;
    private String password;
    private String captcha;
}
