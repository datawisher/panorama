package com.datawisher.bee.system.async;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

/**
 * @author h407644
 * @date 2023-02-18
 */
public class CompletableFutureTest {

    @Test
    public void testRunAsync() {
        System.out.println("main====>");
        String str = "inputString";
        CompletableFuture.runAsync(() -> asyncMethod(str));
    }

    void asyncMethod(String str) {
        System.out.println("str = " + str);
    }
}
