package com.mvc.component.spring.quartz;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

public class CustomerJob {
    public void run(){
        System.out.println(this.getClass().getSimpleName()+" is running at"+DateFormatUtils.format(new Date(),"yyyyMMdd hh:mm:ss") );
    }
}
