package com.datawisher.misc.jdk8.lambda;

import com.datawisher.misc.jdk8.lambda.model.Student;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  将流转换成list。 还有toSet()，toMap()等。及早求值。
 */
public class CollectMethod {

    public static void main(String[] args) {
        List<Student> studentList = Stream.of(new Student("路飞", 22, 175),
                new Student("红发", 40, 180),
                new Student("白胡子", 50, 185)).collect(Collectors.toList());
        System.out.println(studentList);
    }
}
