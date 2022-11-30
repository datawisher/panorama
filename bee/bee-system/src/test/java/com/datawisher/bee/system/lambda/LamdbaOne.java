package com.datawisher.bee.system.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author h407644
 * @date 2022-11-30
 */
public class LamdbaOne {

    List<GroupModel> groupModels = new ArrayList<>();

    @BeforeEach
    public void init() {
        GroupModel groupModel;
        groupModels.add(new GroupModel("A", 3));
        groupModels.add(new GroupModel("B",2));
        groupModels.add(new GroupModel("A",1));
        groupModels.add(new GroupModel("C",5));
    }

    @Test
    public void groupby() {

        Map<String, Integer> rs = groupModels.stream().collect(Collectors.groupingBy(GroupModel::getGroup,
                Collectors.summingInt(GroupModel::getNum)));
        System.out.println("rs = " + rs);
    }

}
