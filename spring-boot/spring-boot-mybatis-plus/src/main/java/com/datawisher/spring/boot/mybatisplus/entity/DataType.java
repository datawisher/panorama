package com.datawisher.spring.boot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jim Han
 * @since 2021-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DataType implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;

    private Byte myByte;

    private Short myShort;

    private Long myLong;

    private Float myFloat;

    private Double myDouble;

    private Boolean myBoolean;

    private String myString;

    private byte[] myByteArr;

    private BigDecimal myBigDecimal;

    private Timestamp myDate;

    private Timestamp myDatetime;


}
