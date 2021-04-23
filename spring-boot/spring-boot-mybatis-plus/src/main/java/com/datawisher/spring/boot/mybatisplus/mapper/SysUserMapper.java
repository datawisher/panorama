package com.datawisher.spring.boot.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datawisher.spring.boot.mybatisplus.entity.SysUser;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jim Han
 * @since 2021-03-13
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<Map<String, Object>> selectByIdFromDifferentDB();

    List<Map<String, Object>> selectDifferentColumnFromDifferentDB();
}
