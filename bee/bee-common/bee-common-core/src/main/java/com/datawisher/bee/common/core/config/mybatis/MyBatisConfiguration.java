package com.datawisher.bee.common.core.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author h407644
 * @date 2022-09-10
 */
@MapperScan("com.datawisher.bee.**.mapper")
@Configuration
public class MyBatisConfiguration {
}
