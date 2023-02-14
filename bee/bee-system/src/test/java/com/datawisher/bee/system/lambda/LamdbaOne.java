package com.datawisher.bee.system.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import io.swagger.models.auth.In;

/**
 * @author h407644
 * @date 2022-11-30
 */
public class LamdbaOne {

    List<GroupModel> groupModels = new ArrayList<>();
    List<Integer> dataList = new ArrayList<>();
    List<Integer> dataList2 = new ArrayList<>();
    List<Map<String, Object>> dataMaps = new ArrayList<>();

    @BeforeEach
    public void init() {
        GroupModel groupModel;
        // List<Object>
        groupModels.add(new GroupModel("A", 3));
        groupModels.add(new GroupModel("B",2));
        groupModels.add(new GroupModel("A",1));
        groupModels.add(new GroupModel("C",5));

        // List<Integer>
        dataList = Arrays.asList(1, 1, 1, 1, 1);
        dataList2 = Arrays.asList(1,1,2,3,6,6);

        // Map
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("item_text", "WS001");
        dataMap.put("item_value", "WS001");
        dataMaps.add(dataMap);
        Map<String, Object> dataMap2 = new HashMap<>();
        dataMap2.put("item_text", "RQ-SP");
        dataMap2.put("item_value", "RQ-SP");
        dataMaps.add(dataMap2);


    }

    @Test
    public void groupby() {

        Map<String, Integer> rs = groupModels.stream().collect(Collectors.groupingBy(GroupModel::getGroup,
                Collectors.summingInt(GroupModel::getNum)));
        System.out.println("rs = " + rs);
    }

    @Test
    public void mapInList() {
        System.out.println("aaaa = " + dataMaps.stream()
                .map(a -> a.values()).map(b -> b.stream().findAny().get()).collect(Collectors.toList()));

    }

    @Test
    public void testAllMatch() {
        boolean data = dataList.stream().allMatch(e -> e.equals(1));
        System.out.println("data ===> " + data);

    }

    @Test
    public void testMultiOperation() {
        System.out.println("groupModels = " + groupModels);
        GroupModel groupModel = groupModels.stream().filter(e -> e.getNum() == 2).findFirst().orElse(new GroupModel("F", 8));
        System.out.println("groupModel1 = " + groupModel);
        groupModel = groupModels.stream().filter(e -> e.getNum() == 5).findFirst().orElse(new GroupModel("F", 8));
        System.out.println("groupModel2 = " + groupModel);
    }

    @Test
    public void testMinRecords() {
        Integer integer = dataList2.stream().sorted().findFirst().orElse(null);
        System.out.println("integer = " + integer);
        int i = dataList2.indexOf(3);
        System.out.println("i = " + i);
    }
}
