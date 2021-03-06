package com.datawisher.com.datawisher.spring.boot.druid.aaa.service.impl;

import com.datawisher.com.datawisher.spring.boot.druid.aaa.entity.Demo;
import com.datawisher.com.datawisher.spring.boot.druid.aaa.mapper.DemoMapper;
import com.datawisher.com.datawisher.spring.boot.druid.aaa.service.IDemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jim Han
 * @since 2021-03-05
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements IDemoService {

}
