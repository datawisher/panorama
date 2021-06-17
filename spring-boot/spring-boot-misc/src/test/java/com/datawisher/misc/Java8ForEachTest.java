package com.datawisher.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

/**
 * @author h407644
 * @date 2021-06-08
 */
public class Java8ForEachTest {

    /**
     *  iterator 的 forEach
     */
    @Test
    public void iteratorForEach() {
        List<String> names = Arrays.asList("Alex", "Brian", "Charles");
        names.forEach(System.out::println);
    }

    @Test
    public void createConsumerAction() {
        List<String> names = Arrays.asList("Alex", "Brian", "Charles");

        Consumer<String> makeUpperCase = new Consumer<String>()
        {
            @Override
            public void accept(String t)
            {
                System.out.println(t.toUpperCase());
            }
        };

        names.forEach(makeUpperCase);
    }

    /**
     *  Map 的 forEach
     */
    @Test
    public void mapForEach() {
        Map<String, String> map = new HashMap<>(3);

        map.put("A", "Alex");
        map.put("B", "Brian");
        map.put("C", "Charles");

        map.forEach((k, v) ->
                System.out.println("Key = " + k + ", Value = " + v));
    }

    @Test
    public void createCustomBiConsumer() {
        BiConsumer<String, Integer> action = (a, b) ->
        {
            //Process the entry here as per business
            System.out.println("Key is : " + a);
            System.out.println("Value is : " + b);
        };

        Map<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        map.forEach(action);
    }

    /**
     *  stream 的 foreach 和 forEachOrdered
     *  如果stream是串行执行的，foreach 和 forEachOrdered 这两个方法没区别
     *  如果stream是并行执行的，需要使用 forEachOrdered 排序
     */
    @Test
    public void streamForEach() {
        List<Integer> numberList = Arrays.asList(1,2,3,4,5);
        Consumer<Integer> action = System.out::println;
        numberList.stream()
                .filter(n -> n%2  == 0)
                .forEach( action );
    }

    @Test
    public void streamForEachOrdered() {
        List<Integer> numberList = Arrays.asList(1,2,3,4,5);
        Consumer<Integer> action = System.out::println;
        numberList.stream()
                .filter(n -> n%2  == 0)
                .parallel()
                .forEachOrdered( action );
    }

}
