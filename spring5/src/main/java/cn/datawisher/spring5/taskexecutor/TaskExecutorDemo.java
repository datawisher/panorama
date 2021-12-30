package cn.datawisher.spring5.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author h407644
 * @date 2021-12-30
 */
public class TaskExecutorDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);

        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }
}
