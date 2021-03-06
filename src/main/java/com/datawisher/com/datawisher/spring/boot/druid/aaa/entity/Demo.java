package com.datawisher.com.datawisher.spring.boot.druid.aaa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jim Han
 * @since 2021-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Demo implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String name;

    private Boolean bools;

    private LocalDateTime dates;

    private String chsname;

    private LocalDateTime datesTwo;

    private LocalDate datesThree;


}
