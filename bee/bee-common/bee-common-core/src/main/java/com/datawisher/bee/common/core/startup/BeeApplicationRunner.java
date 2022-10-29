package com.datawisher.bee.common.core.startup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author h407644
 * @date 2022-10-06
 */
@Component
public class BeeApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.err.println("===> ApplicationRunner <===");
    }
}
