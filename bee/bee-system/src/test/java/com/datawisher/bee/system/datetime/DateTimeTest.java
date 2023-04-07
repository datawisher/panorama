package com.datawisher.bee.system.datetime;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * @author h407644
 * @date 2023-03-05
 */
public class DateTimeTest {

    @Test
    public void testDateTimeFormatter() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        System.out.println("format = " + format);
    }
}
