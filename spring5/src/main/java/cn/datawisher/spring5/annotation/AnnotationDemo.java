package cn.datawisher.spring5.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author h407644
 * @date 2022-01-02
 */
public class AnnotationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        AnnotationService annotationService = context.getBean(AnnotationService.class);
        annotationService.outputResult();
        context.close();
    }
}
