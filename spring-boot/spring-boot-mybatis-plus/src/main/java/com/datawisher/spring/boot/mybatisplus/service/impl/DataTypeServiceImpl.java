package com.datawisher.spring.boot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.datawisher.spring.boot.mybatisplus.entity.DataType;
import com.datawisher.spring.boot.mybatisplus.mapper.DataTypeMapper;
import com.datawisher.spring.boot.mybatisplus.service.IDataTypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jim Han
 * @since 2021-03-07
 */
@Service
public class DataTypeServiceImpl extends ServiceImpl<DataTypeMapper, DataType> implements
        IDataTypeService {

}
