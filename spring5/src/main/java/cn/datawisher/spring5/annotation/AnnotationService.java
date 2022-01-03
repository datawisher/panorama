package cn.datawisher.spring5.annotation;

import org.springframework.stereotype.Service;

/**
 * @author h407644
 * @date 2022-01-02
 */
@Service
public class AnnotationService {
    public void outputResult() {
        System.err.println("从组合注解配置照样获得的 bean");
    }
}
