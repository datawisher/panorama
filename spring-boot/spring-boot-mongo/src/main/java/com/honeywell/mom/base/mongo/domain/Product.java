package com.honeywell.mom.base.mongo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@Document
public class Product extends IncIdEntity<Integer> {

    /**
     * 商品名
     */
    private String name;
}

