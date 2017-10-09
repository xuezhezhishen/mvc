package com.mvc.config;


import com.mvc.component.task.spring.QuartzJob;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.XmlWebApplicationContext;


/**
 * Created by Spencer.hong on 2017/6/16.
 */
@Configuration
@ComponentScan(basePackages = "com.mvc.*.*", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({CachingConfig.class,  MybatisSessionFactoryConfig.class}) //DaoConfig.class,
public class AppConfig {

    //  由于JobDetailBean继承org.quartz.JobDetail，在Quartz 2.0以后，
    // JobDetail改为接口，所以JobDetailBean不支持Quartz 2.0以上版本。
    // 如果使用Quartz2.0以上版本，可以使用JobDetailFactoryBean。支持的属性设置，与JobDetailBean相同。

    //配置作业类
    @Bean("jobExample")
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(QuartzJob.class);
        JobDataMap dataMap = new JobDataMap();
        dataMap.putAsString("longtime", System.currentTimeMillis());
        jobDetailFactoryBean.setJobDataAsMap(dataMap);
//        jobDetailFactoryBean.setName("jobExample");
        return jobDetailFactoryBean;
    }

    //配置作业调度的触发方式
    @Bean("exampleTrigger")
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean().getObject());
        simpleTriggerFactoryBean.setStartDelay(0);
        simpleTriggerFactoryBean.setRepeatInterval(5000);
        return simpleTriggerFactoryBean;
    }

    //配置调度工厂
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean().getObject());
        return schedulerFactoryBean;
    }
}
