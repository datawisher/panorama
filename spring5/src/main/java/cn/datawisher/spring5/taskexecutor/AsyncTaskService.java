package cn.datawisher.spring5.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author h407644
 * @date 2021-12-30
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer i) {
        System.err.println("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.err.println("执行异步任务+1：" + (i+1));
    }
}
