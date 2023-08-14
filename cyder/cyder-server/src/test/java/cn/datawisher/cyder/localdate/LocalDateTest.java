package cn.datawisher.cyder.localdate;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class LocalDateTest {

    @Test
    public void testLocalDate01() {
        LocalDate date = LocalDate.of(2023, 6, 3);
        System.out.println("date.withDayOfMonth(1) = " + date.withDayOfMonth(1));
        System.out.println("date.withDayOfMonth(date.lengthOfMonth()) = " + date.withDayOfMonth(date.lengthOfMonth()));
    }
}

