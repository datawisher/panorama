package com.datawisher.spring.boot.test;

import com.datawisher.spring.boot.test.model.User;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ListTest {

    /**
     *  List lambda 去重
     */
    @Test
    public void allListTest() {
        List<User> allList = new ArrayList();
        User user1 = new User();
        user1.setId("333");
        allList.add(user1);
        User user2 = new User();
        user2.setId("222");
        allList.add(user2);
        User user3 = new User();
        user3.setId("111");
        allList.add(user3);
        User user4 = new User();
        user4.setId("333");
        allList.add(user4);
        //allList是需要去重的list，返回值是去重后的list
        List<User> distincts = allList.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getId()))),
                ArrayList::new));
        System.out.println(distincts);

    }

    /**
     *  List lambda 分页
     */
    @Test
    public void pageTest() {
        List<User> allList = new ArrayList();
        User user1 = new User();
        user1.setId("111");
        allList.add(user1);
        User user2 = new User();
        user2.setId("222");
        allList.add(user2);
        User user3 = new User();
        user3.setId("333");
        allList.add(user3);
        User user4 = new User();
        user4.setId("444");
        allList.add(user4);
        User user5 = new User();
        user5.setId("555");
        allList.add(user5);

        int pageSize=2;
        int pageNum=2;
        List<User> result = allList.stream().skip(pageSize * (pageNum - 1)).limit(pageSize).collect(Collectors.toList());
        System.out.println("result = " + result);
    }

}
