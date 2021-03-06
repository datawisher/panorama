package com.honeywell.mom.base.mongo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * 自增主键实体
 *
 * @param <T> 主键泛型
 */
@Data
public class IncIdEntity<T extends Number> {

    @Id
    private T id;
}
