package com.datawisher.bee.system.login.service;

import com.datawisher.bee.common.model.dto.Result;
import com.datawisher.bee.system.login.LoginDTO;

/**
 * @author h407644
 * @date 2023-01-15
 */
public interface LoginService {

    Result<?> login(LoginDTO loginDTO);
}
