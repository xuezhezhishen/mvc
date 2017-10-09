package com.mvc.component.task.spring;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzJob  extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        System.out.println(DateFormatUtils.format(new Date(),"yyyyMMdd hh:mm:ss") +":" + context.getMergedJobDataMap().get("longtime"));
    }
}
