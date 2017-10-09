package com.mvc.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

@Order(3)
//spring DispatcherServlet的配置,其它servlet和监听器等需要额外声明，用@Order注解设定启动顺序
// 加载DispatcherServlet
public class WebInitializerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
      * DispatcherServlet的映射路径
      */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /*
      * 注册过滤器，映射路径与DispatcherServlet一致，路径不一致的过滤器需要注册到另外的WebApplicationInitializer中
      */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{characterEncodingFilter};
    }

    /*
      * 应用上下文，除dispatchServlet 部分
      */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    protected Class[] getRootConfigClasses() {
        //类似其他配置文件加载  root 上下文的contextConfigLocation  上下文配置文件
//        return new Class[]{AppConfig.class, SpringSecurityConfig.class};
        return new Class[]{AppConfig.class};
    }

    /*
      * dispatchServlet上下文
      */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    protected Class[] getServletConfigClasses() {
        // servlet 上下文的上下文的contextConfigLocation 配置文件
        return new Class[]{MvcConfig.class};
    }

}
