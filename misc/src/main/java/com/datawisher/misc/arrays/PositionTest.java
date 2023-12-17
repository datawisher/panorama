package com.datawisher.misc.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PositionTest {
    public static void main(String[] args) {
        String[] arr = {"110", "115", "167", "189", "192"};
        String target = "116";

        List<String> list = new ArrayList<>(Arrays.asList(arr));

        int insertPosition = Arrays.binarySearch(arr, target);
        if (insertPosition < 0) {
            insertPosition = -insertPosition - 1; // 获取应插入位置的索引
        }

        int insertPosition2 = Collections.binarySearch(list, target);
        if (insertPosition2 < 0) {
            insertPosition2 = -insertPosition2 - 1;
        }

        list.add(3, "111");

        System.out.println("字符 'c' 应插入的位置为：" + insertPosition);
        System.out.println("字符 'c' 应插入的位置为：" + insertPosition2);
    }
}
