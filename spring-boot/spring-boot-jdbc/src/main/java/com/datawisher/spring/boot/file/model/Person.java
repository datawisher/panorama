package com.datawisher.spring.boot.file.model;


import java.io.Serializable;
import lombok.Data;

/**
 * @author Jim Han
 */
@Data
public class Person implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    private String name;

    private Integer age;
}
