package com.datawisher.spring.boot.swagger;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSwaggerTest {

    @Test
    public void testLambda() {
        Runnable runnable = () -> System.out.println("hello world");
        IntConsumer intConsumer = System.out::println;
    }
}
