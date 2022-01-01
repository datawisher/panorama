package cn.datawisher.spring5.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author h407644
 * @date 2022-01-01
 */
public class ConditionalDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);

        System.err.println(context.getEnvironment().getProperty("os.name")
                + "系统下的列表命令为："
                + listService.showListCmd());
    }
}
