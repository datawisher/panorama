package com.datawisher.misc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * @author h407644
 * @date 2021-06-10
 */
public class Java8BoxedTest {

    @Test
    public void primitiveBoxed() {
        // 基本类型需要装箱后才能转成 stream 的 List，否则编译器报错， 原因是无法推断R参数类型
        // 类似接口有 LongStream, DoubleStream
        List<Integer> collect = IntStream.of(1, 2, 3, 4).boxed().collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

}
