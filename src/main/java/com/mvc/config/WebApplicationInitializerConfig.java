package com.mvc.config;

import com.mvc.servlet.DemoServlet;
import org.springframework.core.annotation.Order;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.EnumSet;

/**
 * Created by Spencer.hong on 2017/6/16.
 */
@Order(1)
public class WebApplicationInitializerConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext)
        throws ServletException {

        //Log4jConfigListener
        servletContext.setInitParameter("log4jConfigLocation", "classpath:config/properties/log4j.properties");
        servletContext.addListener(Log4jConfigListener.class);


        //OpenSessionInViewFilter
//        OpenSessionInViewFilter hibernateSessionInViewFilter = new OpenSessionInViewFilter();
//        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter(
//            "hibernateFilter", hibernateSessionInViewFilter);
//        filterRegistration.addMappingForUrlPatterns(
//            EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/");


        //DemoServlet
        DemoServlet demoServlet = new DemoServlet();
        ServletRegistration.Dynamic dynamic = servletContext.addServlet(
            "demoServlet", demoServlet);
        dynamic.setLoadOnStartup(2);
        dynamic.addMapping("/demo_servlet","/demo_servlet/*");


    }

}