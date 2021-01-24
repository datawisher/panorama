package com.datawisher.spring.boot.elasticsearch.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
public class Author {

    @Field(type = FieldType.Text)
    private String name;

    public Author(String name){
        this.name = name;
    }
}
