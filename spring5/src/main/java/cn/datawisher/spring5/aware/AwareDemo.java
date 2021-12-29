package cn.datawisher.spring5.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author h407644
 * @date 2021-12-29
 */
public class AwareDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);

        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();
        context.close();
    }
}
