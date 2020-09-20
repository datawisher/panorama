package com.datawisher.spring.boot.i18n;

import java.util.Locale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class I18nTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    public void testMessage() {
        String message = messageSource.getMessage("message", null, "Default", Locale.CHINA);
        System.out.println(message);
    }
}
