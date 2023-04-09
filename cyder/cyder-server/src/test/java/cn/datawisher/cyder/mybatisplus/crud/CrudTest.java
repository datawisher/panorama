package cn.datawisher.cyder.mybatisplus.crud;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.datawisher.cyder.system.user.entity.SysUser;
import cn.datawisher.cyder.system.user.mapper.SysUserMapper;

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

    @Test
    public void testSelect() {
        Page<SysUser> page = new Page<>(2, 5);
        Page<SysUser> sysUserPage = mapper.selectPage(page, null);
        System.out.println(JSONObject.toJSONString(sysUserPage, JSONWriter.Feature.WriteNulls));
    }

}
