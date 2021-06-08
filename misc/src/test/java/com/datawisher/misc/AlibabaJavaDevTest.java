package com.datawisher.misc;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
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

    /**
     * 数组转List注意事项
     */
    @Test
    public void arrayToList() {
        String[] str = new String[] { "jim", "han" };
        List list = Arrays.asList(str);
        Assertions.assertEquals(Arrays.toString(str), list.toString());
        // 修改了数组中的元素，对应的list也会被修改，Arrays.asList体现的是适配器模式，只是转换接口，后台的数据仍是数组
        str[0] = "jing";
        Assertions.assertEquals(Arrays.toString(str), list.toString());
        // 不能对Arrays.asList使用add，remove，clear等方法，否则会抛出如下异常
        Assertions.assertThrows(UnsupportedOperationException.class, () -> list.add("qiang"));
    }

    /**
     *  循环遍历集合的过程中 add/remove 元素
     */
    @Test
    public void addOrRemoveElementWhenForeach() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Assertions.assertThrows(ConcurrentModificationException.class, () -> {
            for (String item : list) {
                // 如果删除list头元素，并不会抛出异常
                if ("2".equals(item)) {
                    list.remove(item);
                }
            }
        });
    }
}
