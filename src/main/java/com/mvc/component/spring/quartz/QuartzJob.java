package com.mvc.component.spring.quartz;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class QuartzJob  extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        System.out.println(this.getClass().getSimpleName() + "is running at "
                +DateFormatUtils.format(new Date(),"yyyyMMdd hh:mm:ss") +":" + context.getMergedJobDataMap().get("longtime"));
    }
}
