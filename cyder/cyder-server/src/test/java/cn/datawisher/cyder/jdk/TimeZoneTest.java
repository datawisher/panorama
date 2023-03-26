package cn.datawisher.cyder.jdk;

import java.util.TimeZone;

import org.junit.jupiter.api.Test;

public class TimeZoneTest {

    @Test
    public void testTimeZone() {
        TimeZone timeZone = TimeZone.getTimeZone("CST");
        System.out.println(timeZone);
    }
}
