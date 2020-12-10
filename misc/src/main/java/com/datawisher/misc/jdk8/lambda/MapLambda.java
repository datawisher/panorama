package com.datawisher.misc.jdk8.lambda;

import java.util.HashMap;
import java.util.Map;

public class MapLambda {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");

        System.out.println("map普通方式遍历:");
        for (String key : map.keySet()) {
            System.out.println("k=" + key + "，v=" + map.get(key));
        }

        System.out.println("map拉姆达表达式遍历:");
        map.forEach((k, v) -> {
            System.out.println("k=" + k + "，v=" + v);
        });
    }
}
