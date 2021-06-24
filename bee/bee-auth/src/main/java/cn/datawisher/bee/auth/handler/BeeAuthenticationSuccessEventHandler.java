package cn.datawisher.bee.auth.handler;

import cn.datawisher.bee.base.security.handler.AbstractAuthenticationSuccessEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @author h407644
 * @date 2021-06-23
 */
@Slf4j
@Component
public class BeeAuthenticationSuccessEventHandler extends
        AbstractAuthenticationSuccessEventHandler {
    /**
     * 处理登录成功方法
     * 获取到登录的authentication 对象
     * @param authentication 登录对象
     */
    @Override
    public void handle(Authentication authentication) {
        log.info("用户：{} 登录成功", authentication.getPrincipal());
    }

}
