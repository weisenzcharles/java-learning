package org.charles.springboot.cheduled;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
@EnableScheduling   // 启用定时任务
public class ScheduledTasks {

    private static final Log log = LogFactory.getLog(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 每 5 秒执行一次任务。
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void timedTask() {
        log.info("执行定时任务：" + Thread.currentThread().getName() + " 执行时间 -> " + dateFormat.format(new Date()));
    }

    /**
     * 每隔 1 秒执行一次任务，等待 2 秒。
     */
    @Async
    @Scheduled(fixedRate = 1000)
    public void asyncScheduleTask() {
        try {
            Thread.sleep(2000);
            log.info("执行定时任务：" + Thread.currentThread().getName() + " 执行时间 -> " + dateFormat.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}