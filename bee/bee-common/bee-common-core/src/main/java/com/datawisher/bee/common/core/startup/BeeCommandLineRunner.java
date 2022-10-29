package com.datawisher.bee.common.core.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author h407644
 * @date 2022-10-06
 */
@Component
public class BeeCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.err.println("===> CommandLineRunner <===");
    }
}
