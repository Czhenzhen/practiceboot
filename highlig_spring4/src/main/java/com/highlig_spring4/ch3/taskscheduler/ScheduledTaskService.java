package com.highlig_spring4.ch3.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
  * 计划任务执行类
  *
  * @author  changzhenzhen
  * @date 2018-10-18
  */
@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //使用@Scheduled声明该方法是计划任务，使用fixRated属性每隔固定时间执行，是两个任务任务开始的间隔时间
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔5秒执行一次"+dateFormat.format(new Date()));
    }

    //使用@cron属性可按照指定时间执行，本例指的是每天11点28分执行；
    // cron是UNIX和类UNIX（Linux）系统下的定时任务
    @Scheduled(cron="39 04 14 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间"+dateFormat.format(new Date())+"执行");
    }

    //fixedDelay间隔时间是前一次任务结束语后一次任务开始的间隔时间
    @Scheduled(fixedDelay = 2000)
    public void runFixedRateTime(){
        System.out.println("每隔两秒执行一次"+dateFormat.format(new Date()));
    }

}
