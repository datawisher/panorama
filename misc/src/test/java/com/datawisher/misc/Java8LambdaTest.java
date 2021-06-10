package com.datawisher.misc;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import org.junit.jupiter.api.Test;

/**
 *
 * (parameters) -> expression
 *
 * @author h407644
 * @date 2021-06-10
 */
public class Java8LambdaTest {

    /**
     *  使用lambda表达式遍历list
     */
    @Test
    public void forEachLambda() {
        List<String> pointList = new ArrayList();
        pointList.add("1");
        pointList.add("2");
        pointList.forEach(p ->  { System.out.println(p); } );
    }

    /**
     *  使用lambda表达式创建启动线程
     */
    @Test
    public void createAndStartThread() {
        new Thread(
                () -> System.out.println("My Runnable")
        ).start();
    }

    /**
     *  为GUI增加监听器
     */
    @Test
    public void GUIEvent() {
        JButton button =  new JButton("Submit");
        button.addActionListener((e) -> {
            System.out.println("Click event triggered !!");
        });
    }
}
