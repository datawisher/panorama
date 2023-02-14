package com.datawisher.bee.system.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author h407644
 * @date 2023-02-06
 */
public class ListTest {

    List<Integer> dataList = new ArrayList<>();
    List<String> dataList2 = new ArrayList<>();

    @BeforeEach
    public void init() {
        dataList = Arrays.asList(1, 1, 1, 1, 1);
        dataList2 = Arrays.asList("aa", "bb", "cc");
    }

    @Test
    public void printList() {
        System.out.println("dataList = " + dataList);
        String[] strings = dataList2.toArray(new String[0]);
        System.out.println("strings = " + strings);
    }
}
