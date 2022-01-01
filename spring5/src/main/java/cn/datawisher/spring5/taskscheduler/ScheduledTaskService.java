package cn.datawisher.spring5.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author h407644
 * @date 2022-01-01
 */
@Service
public class ScheduledTaskService {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.err.println("每隔5秒执行一次 " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 58 21 ? * *")
    public void fixTimeExecution() {
        System.err.println("在指定时间 " + dateFormat.format(new Date()) + "执行");
    }

}
