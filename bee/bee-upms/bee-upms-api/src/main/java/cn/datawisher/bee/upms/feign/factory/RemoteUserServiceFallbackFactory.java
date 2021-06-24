package cn.datawisher.bee.upms.feign.factory;

import cn.datawisher.bee.upms.feign.RemoteUserService;
import cn.datawisher.bee.upms.feign.fallback.RemoteUserServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author h407644
 * @date 2021-06-22
 */
@Component
public class RemoteUserServiceFallbackFactory implements FallbackFactory<RemoteUserService> {

    @Override
    public RemoteUserService create(Throwable cause) {
        RemoteUserServiceFallbackImpl remoteUserServiceFallback = new RemoteUserServiceFallbackImpl();
        remoteUserServiceFallback.setCause(cause);
        return remoteUserServiceFallback;
    }
}
