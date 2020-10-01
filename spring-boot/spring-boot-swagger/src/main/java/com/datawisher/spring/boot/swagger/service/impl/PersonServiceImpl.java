package com.datawisher.spring.boot.swagger.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datawisher.spring.boot.swagger.entity.Person;
import com.datawisher.spring.boot.swagger.mapper.PersonMapper;
import com.datawisher.spring.boot.swagger.service.IPersonService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jim Han
 * @since 2020-09-19
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
