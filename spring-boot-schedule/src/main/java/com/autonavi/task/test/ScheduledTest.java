package com.autonavi.task.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by chenweiqiang on 2017/6/27.
 */


@Component
public class ScheduledTest {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTest.class);

    @Scheduled(cron="0 0/2 8-20 * * ?")
    public void executeFileDownLoadTask(){
        Thread current = Thread.currentThread();
        System.out.println("定时任务1：" + current.getId());
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:" + current.getId() + ",name:" + current.getName());
    }
}
