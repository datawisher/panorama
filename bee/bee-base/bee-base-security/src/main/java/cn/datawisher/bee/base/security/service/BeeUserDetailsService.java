package cn.datawisher.bee.base.security.service;

import cn.datawisher.bee.base.core.constant.CacheConstants;
import cn.datawisher.bee.base.core.constant.SecurityConstants;
import cn.datawisher.bee.upms.dto.UserInfo;
import cn.datawisher.bee.upms.entity.SysUser;
import cn.datawisher.bee.upms.feign.RemoteUserService;
import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.extension.api.R;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author h407644
 * @date 2021-06-22
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BeeUserDetailsService implements UserDetailsService {

    private final RemoteUserService remoteUserService;
    private final CacheManager cacheManager;

    // 从Redis取用户，没有则查询upms
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cache cache = cacheManager.getCache(CacheConstants.USER_DETAILS);
        if (cache != null && cache.get(username) != null) {
            return (BeeUser) cache.get(username).get();
        }

        R<UserInfo> result = remoteUserService.info(username, SecurityConstants.FROM_IN);
        UserDetails userDetails = getUserDetails(result);
        if (cache != null) {
            cache.put(username, userDetails);
        }
        return userDetails;
    }

    /**
     * 构建userdetails
     *
     * @param result 用户信息
     * @return
     */
    private UserDetails getUserDetails(R<UserInfo> result) {
        if (result == null || result.getData() == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        UserInfo info = result.getData();
        Set<String> dbAuthsSet = new HashSet<>();
        if (ArrayUtil.isNotEmpty(info.getRoles())) {
            // 获取角色
            Arrays.stream(info.getRoles())
                    .forEach(role -> dbAuthsSet.add(SecurityConstants.ROLE + role));
            // 获取资源
            dbAuthsSet.addAll(Arrays.asList(info.getPermissions()));

        }
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils
                .createAuthorityList(dbAuthsSet.toArray(new String[0]));
        SysUser user = info.getSysUser();

        // 构造security用户
        return new BeeUser(user.getId(), user.getDeptId(), user.getUsername(),
                user.getPassword(), user.isEnabled(),
                true, true, true,
                authorities);
    }
}
