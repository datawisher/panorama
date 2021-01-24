package com.datawisher.spring.boot.elasticsearch.domain;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

@Data
@NoArgsConstructor
@Document(indexName = "blog")
public class Article {

    @Id
    private String id;

    @MultiField(mainField = @Field(type = FieldType.Text, fielddata = true),
            otherFields = { @InnerField(suffix = "verbatim", type = FieldType.Keyword) })
    private String title;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;

    @Field(type = FieldType.Keyword)
    private String[] tags;

    public Article(String title) {
        this.title = title;
    }

}
