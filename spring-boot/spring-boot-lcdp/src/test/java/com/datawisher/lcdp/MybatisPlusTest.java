package com.datawisher.lcdp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.datawisher.lcdp.upms.domain.Staff;
import com.datawisher.lcdp.upms.mapper.StaffMapper;
import com.datawisher.lcdp.upms.service.StaffService;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author h407644
 * @date 2021-05-28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 避免websocket服务报错
public class MybatisPlusTest {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private StaffService staffService;

    @Test
    public void testSelectList() {
        List<Staff> list = staffMapper.selectList(null);
        assertEquals(5, list.size());
        list.forEach(System.out::println);
    }

    /**
     *  只查部份列
     */
    @Test
    public void testSelectMaps() {
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        wrapper.select("id","name","email").likeRight("name","黄");
        List<Map<String, Object>> maps = staffMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    // 按照直属上级进行分组，查询每组的平均年龄，最大年龄，最小年龄
    /**
     select avg(age) avg_age ,min(age) min_age, max(age) max_age from staff group by manager_id having sum(age) < 500;
     **/
    @Test
    public void testStatistics() {
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        wrapper.select("manager_id", "avg(age) avg_age", "min(age) min_age", "max(age) max_age")
                .groupBy("manager_id").having("sum(age) < {0}", 500);
        List<Map<String, Object>> maps = staffMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }


    @Test
    public void testGetOne() {
        LambdaQueryWrapper<Staff> wrapper = Wrappers.lambdaQuery();
        wrapper.gt(Staff::getAge, 28);
        Staff one = staffService.getOne(wrapper, false); // 第二参数指定为false,使得在查到了多行记录时,不抛出异常,而返回第一条记录
        System.out.println(one);
    }

    /**
     *  lambda 链式查询
     */
    @Test
    public void testChain() {
        List<Staff> list = staffService.lambdaQuery()
                .gt(Staff::getAge, 39)
                .likeRight(Staff::getName, "王")
                .list();
        list.forEach(System.out::println);
    }

}
