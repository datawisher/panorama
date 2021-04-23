package com.datawisher.spring.boot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datawisher.spring.boot.mybatisplus.entity.IdentityDemo;
import com.datawisher.spring.boot.mybatisplus.mapper.IdentityDemoMapper;
import com.datawisher.spring.boot.mybatisplus.service.IIdentityDemoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jim Han
 * @since 2021-03-11
 */
@Service
public class IdentityDemoServiceImpl extends ServiceImpl<IdentityDemoMapper, IdentityDemo> implements IIdentityDemoService {

}
