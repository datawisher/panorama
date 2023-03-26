package cn.datawisher.cyder.mybatisplus.crud;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import cn.datawisher.cyder.sysuser.entity.SysUser;
import cn.datawisher.cyder.sysuser.mapper.SysUserMapper;

@SpringBootTest
public class CrudTest {

    @Autowired
    private SysUserMapper mapper;

    @Test
    public void testInsert() {
        SysUser users = new SysUser();
        users.setUsername("fingerlake");
        users.setPassword("abbccddee");
        users.setEmail("hj_hanjing@163.com");
        users.setRealName("张嘎子");
        mapper.insert(users);
    }

    @Test

    public void testUpdate() {
        mapper.update(
                null,
                Wrappers.<SysUser>lambdaUpdate()
                        .set(SysUser::getAddress, "上海")
                        .eq(SysUser::getId, 1639514393509138434L)
        );
    }

}
