package com.datawisher.bee.system.text;

import org.apache.commons.lang3.CharUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author h407644
 * @date 2022-12-02
 */
public class StringTest {

    String secA;

    @BeforeEach
    public void init() {
        secA = "RQ003";
    }

    @Test
    public void testSubString() {
        String txt = "QTY:10.0000";
        String substring = txt.substring(4);
        System.out.println("txt = " + substring);
        System.out.println("txt2 = " + new BigDecimal(substring).intValue());
    }

    @Test
    public void testSubString2() {
        String substring = secA.substring(0, 2);
        System.out.println("substring = " + substring);
    }

    @Test
    public void testStringJoin() {
        Set<String> strings = new HashSet<>();
        strings.add("aa");
        strings.add("cc");
        strings.add("ee");
        String join = String.join(",", strings);
        System.out.println("join ===> " + join);
    }

    @Test
    public void testSplit() {
        String ex1 = "/opt/mesFiles/2022-12-1/J220124-3.pdf";
        String[] split = ex1.split("/opt/mesFiles");
        String s = Arrays.asList(split).toString();
        System.out.println("s = " + s);
    }
}
