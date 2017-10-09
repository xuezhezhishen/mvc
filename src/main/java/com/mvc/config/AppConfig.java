package com.mvc.config;

import com.mvc.component.spring.quartz.CustomerJob;
import com.mvc.component.spring.quartz.QuartzJob;
import org.quartz.JobDataMap;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.*;


/**
 * Created by Spencer.hong on 2017/6/16.
 */
@Configuration
@ComponentScan(basePackages = {"com.mvc.component.*.*"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableScheduling
@EnableAsync
@Import({CachingConfig.class,  DaoConfig.class, MybatisSessionFactoryConfig.class})
public class AppConfig {

    //  由于JobDetailBean继承org.spring.JobDetail，在Quartz 2.0以后，
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

    // 方式一
    //配置作业调度的触发方式
    @Bean("exampleTrigger")
        public SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean().getObject());
        simpleTriggerFactoryBean.setStartDelay(0);
        simpleTriggerFactoryBean.setRepeatInterval(5000);
//        simpleTriggerFactoryBean.afterPropertiesSet();
        return simpleTriggerFactoryBean;
    }


    // 方式二
    //配置作业调度的触发方式
    @Bean("exampleCron")
    CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean().getObject());
        cronTriggerFactoryBean.setCronExpression("0 48 * * * ?");
        return  cronTriggerFactoryBean;
    }
    //配置调度工厂
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean().getObject(),
                cronTriggerFactoryBean().getObject(),triggerCustomerJob().getObject());
        return schedulerFactoryBean;
    }


    //自定义job 的调用
    @Bean
    MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean(){
        MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        // 针对静态方法调用
      //  methodInvokingJobDetailFactoryBean.setTargetClass(CustomerJob.class);

        methodInvokingJobDetailFactoryBean.setTargetObject(new CustomerJob());
        methodInvokingJobDetailFactoryBean.setTargetMethod("run");
        methodInvokingJobDetailFactoryBean.setConcurrent(false);
        return methodInvokingJobDetailFactoryBean;
    }
    //配置触发器，如上
    // 方式一
    //配置作业调度的触发方式
    @Bean("triggerCustomerJob")
    public SimpleTriggerFactoryBean triggerCustomerJob(){
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        simpleTriggerFactoryBean.setStartDelay(0);
        simpleTriggerFactoryBean.setRepeatInterval(10000);
//        simpleTriggerFactoryBean.afterPropertiesSet();
        return simpleTriggerFactoryBean;
    }

}
