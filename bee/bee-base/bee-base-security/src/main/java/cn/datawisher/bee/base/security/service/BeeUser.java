package cn.datawisher.bee.base.security.service;

import java.util.Collection;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author h407644
 * @date 2021-06-22
 */
public class BeeUser extends User {

    /**
     * 用户ID
     */
    @Getter
    private Integer id;

    /**
     * 部门ID
     */
    @Getter
    private Integer deptId;

    public BeeUser(Integer id, Integer deptId, String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
        this.id = id;
        this.deptId = deptId;
    }
}
