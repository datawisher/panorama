package com.datawisher.spring.boot.druid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jim Han
 * @since 2020-09-19
 */
@Data
public class Person implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String name;

    private Integer age;


}
