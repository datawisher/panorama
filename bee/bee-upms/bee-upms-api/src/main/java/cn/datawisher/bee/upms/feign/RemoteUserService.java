package cn.datawisher.bee.upms.feign;

import cn.datawisher.bee.base.core.constant.SecurityConstants;
import cn.datawisher.bee.base.core.constant.ServiceNameConstants;
import cn.datawisher.bee.upms.dto.UserInfo;
import cn.datawisher.bee.upms.feign.factory.RemoteUserServiceFallbackFactory;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author h407644
 * @date 2021-06-22
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.UMPS_SERVICE,
        fallbackFactory = RemoteUserServiceFallbackFactory.class)
public interface RemoteUserService {

    /**
     * 通过用户名查询用户、角色信息
     * @param username 用户名
     * @param from 调用标志
     * @return R
     */
    @GetMapping("/user/info/{username}")
    R<UserInfo> info(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM) String from);

    /**
     * 通过社交账号查询用户、角色信息
     * @param inStr appid@code
     * @return R
     */
    @GetMapping("/social/info/{inStr}")
    R<UserInfo> social(@PathVariable("inStr") String inStr);
}
