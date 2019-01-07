package com.jpjproxy.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * spring自带定时器测试
 * @Author: jingpj
 * @Date：creste in 2018/3/8
 */
//@EnableScheduling
@Component
@Slf4j
public class ScheduleTask {
    @Scheduled(cron="0/15 0 1 * * ?")
    public void scheduleTest() {
        log.error("scheduleTest开始定时执行");
//        throw new RuntimeException("异常出现");

    }

}
