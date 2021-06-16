package com.datawisher.lcdp.upms.domain;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author h407644
 * @date 2021-06-15
 */
@Data
public class Staff {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    private LocalDateTime createTime;
}
