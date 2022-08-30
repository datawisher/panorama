package com.datawisher.springframework.util;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author h407644
 * @date 2022-08-30
 */
public class StringUtilsTest {

    public static final String commaStrings = "aa,bb,cc,dd";

    @Test
    public void testCommaDelimitedListToStringArray() {
        String[] strings = StringUtils.commaDelimitedListToStringArray(commaStrings);
        System.out.println("strings = " + Arrays.toString(strings));
    }
}
