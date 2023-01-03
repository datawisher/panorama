package com.datawisher.bee.system.exception;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author h407644
 * @date 2022-12-25
 */
@Slf4j
public class ExceptionTest {

    @Test
    public void testExceptionMessage() {
        try {
            try {
                int i = 10/0;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}
