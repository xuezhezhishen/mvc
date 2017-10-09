package com.mvc.component.spring.task;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("taskExample")
public class TaskExample {

    @Scheduled(cron = "0/30 * * * * ?")
    @Async
    public void run() {
        try{
            Thread.sleep(40000);
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(this.getClass().getSimpleName()+"is running at "+ DateFormatUtils.format(new Date(),"yyyyMMdd hh:mm:ss"));

    }
}
