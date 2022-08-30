package com.datawisher.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @author h407644
 * @date 2022-08-30
 */
public class StringUtilsTest {

    @Test
    public void testAbbreviate() {
        String var01 = StringUtils.abbreviate("abcdefg", 7);
        System.out.println("var01 = " + var01);

    }
}
