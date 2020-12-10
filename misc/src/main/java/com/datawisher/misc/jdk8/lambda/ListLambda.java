package com.datawisher.misc.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;

public class ListLambda {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("bb");
        list.add("ccc");
        list.add("dddd");
        System.out.println("list拉姆达表达式遍历:");
        list.forEach(v -> {
            System.out.println(v);
        });
        System.out.println("list双冒号运算符遍历:");
        list.forEach(System.out::println);
    }
}
