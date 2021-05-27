package com.datawisher.misc.jdk8.stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author h407644
 * @date 2021-05-26
 */
public class ForEachDemo {

    public static void main(String[] args) {
        /*List<Integer> list = Arrays.asList(4, 3, 6, 5, 10);
        list.stream().sorted(Comparator.naturalOrder()).parallel().forEachOrdered( System.out::println );*/

        /*List<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(randomNumbers);*/

        /*LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
//Create stream of dates
        List<LocalDate> dates = Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .collect(Collectors.toList());
        System.out.println(dates);*/

        // ArrayList with duplicate elements
        /*ArrayList<Integer> numbersList
                = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));

        Map<Integer, Long> elementCountMap = numbersList.stream()
                .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));

        System.out.println(elementCountMap);*/
    }
}
