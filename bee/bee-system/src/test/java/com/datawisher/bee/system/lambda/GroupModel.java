package com.datawisher.bee.system.lambda;

import lombok.Data;

/**
 * @author h407644
 * @date 2022-11-30
 */
@Data
public class GroupModel {

    private String group;
    private Integer num;

    public GroupModel(String group, Integer num) {
        this.group = group;
        this.num = num;
    }
}
