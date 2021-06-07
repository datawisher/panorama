package com.datawisher.misc;


import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author h407644
 * @date 2021-06-07
 */
public class AlibabaJavaDevTest {

    /**
     *  浮点数比较
     */
    @Test
    public void FloatEqualsTest() {
        // 浮点数差值计算后的比较
        // 计算机由二进制表示，存在精度误差
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;

        Assertions.assertEquals(false, a == b);

        // 包装类型结果同上
        Float x = Float.valueOf(a);
        Float y = Float.valueOf(b);

        Assertions.assertEquals(false, x.equals(y));

    }

    /**
     *  BigDecimal 运算
     */
    @Test
    public void BigDecimalTest() {
        // 差值计算后的比较
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");
        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);
        Assertions.assertEquals(true, x.equals(y));


        // BigDecimal 推荐创建用法
        BigDecimal recommend1 = new BigDecimal("0.1");
        BigDecimal recommend2 = BigDecimal.valueOf(0.1);
    }
}
