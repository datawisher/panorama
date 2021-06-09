package com.datawisher.misc;

import com.google.common.collect.Streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
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

    /**
     *  stream 的创建
     */
    @Test
    public void createStreamOf() {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        stream.forEach(p -> System.out.println(p));
    }

    @Test
    public void createStreamOfArray() {
        Stream<Integer> stream = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
        stream.forEach(p -> System.out.println(p));
    }

    /**
     *  List stream
     */
    @Test
    public void listStream() {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> stream = list.stream();
        stream.forEach(p -> System.out.println(p));
    }

    /**
     * stream generator()
     */
    @Test
    public void streamGenerator() {
        Stream<Integer> randomNumbers = Stream
                .generate(() -> (new Random()).nextInt(100));

        randomNumbers.limit(20)
                .forEach(System.out::println);
    }

    /**
     * stream of 字符和词条
     */
    @Test
    public void streamOfChar() {
        IntStream stream = "12345_abcdefg".chars();
        stream.forEach(p -> System.out.println(p));
        //OR
        Stream<String> stream2 = Stream.of("A$B$C".split("\\$"));
        stream2.forEach(p -> System.out.println(p));
    }

    /**
     * stream Collectors
     */
    @Test
    public void streamCollectToList() {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> stream = list.stream();
        List<Integer> evenNumbersList = stream.filter(i -> i%2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbersList);
    }

    @Test
    public void streamCollectToArray() {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> stream = list.stream();
        Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0)
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(evenNumbersArr));
    }

    /**
     * Stream Operations - intermediate
     */
    @Test
    public void streamIntermediateOperations() {
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        // filter
        memberNames.stream().filter((s) -> s.startsWith("A"))
                .forEach(System.out::println);

        // map
        memberNames.stream().filter((s) -> s.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // sort
        memberNames.stream().sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    /**
     * Stream Operations - terminal
     */
    @Test
    public void streamTerminalOperations() {
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        // forEach
        memberNames.forEach(System.out::println);

        // collect
        List<String> memNamesInUppercase = memberNames.stream().sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(memNamesInUppercase);

        // match
        boolean matchedResult = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);
        matchedResult = memberNames.stream()
                .allMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);
        matchedResult = memberNames.stream()
                .noneMatch((s) -> s.startsWith("A"));
        System.out.println(matchedResult);

        // count
        long totalMatched = memberNames.stream()
                .filter((s) -> s.startsWith("A"))
                .count();
        System.out.println(totalMatched);

        // reduce
        Optional<String> reduced = memberNames.stream()
                .reduce((s1,s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
    }

    /**
     * Stream Operations - Short-circuit
     */
    @Test
    public void streamShortCircuitOperations() {
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        // anyMatch , 匹配到第一条数据即停止
        boolean matched = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));
        System.out.println(matched);

        // findFirst
        String firstMatchedName = memberNames.stream()
                .filter((s) -> s.startsWith("L"))
                .findFirst()
                .orElse("");
        System.out.println(firstMatchedName);
    }

    /**
     *  并行
     */
    @Test
    public void parallelism() {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        //Here creating a parallel stream
        Stream<Integer> stream = list.parallelStream();
        Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
        System.out.println(Arrays.toString(evenNumbersArr));
    }



}
