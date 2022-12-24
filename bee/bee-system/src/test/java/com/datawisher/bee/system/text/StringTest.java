package com.datawisher.bee.system.text;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * @author h407644
 * @date 2022-12-02
 */
public class StringTest {

    @Test
    public void testSubString() {
        String txt = "QTY:10.0000";
        String substring = txt.substring(4);
        System.out.println("txt = " + substring);
        System.out.println("txt2 = " + new BigDecimal(substring).intValue());
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
}
