package com.mvc.config;

import com.mvc.interrupt.CP_InitializingInterceptor;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by spencer.hong on 2017/6/19.
 */
@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = "com.mvc.controller", useDefaultFilters = false, includeFilters = {
//    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})
//})
@ComponentScan(basePackages = "com.mvc.controller")
public class MvcConfig extends WebMvcConfigurationSupport {

    private static final Logger logger = Logger
        .getLogger(MvcConfig.class);

    /**
     * 描述 : <注册试图处理器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        logger.info("ViewResolver");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    /**
     * 描述 : <注册消息资源处理器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        logger.info("MessageSource");
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("config.message.messages");

        return messageSource;
    }

    /**
     * 描述 : <注册servlet适配器>. <br>
     * <p>
     * <只需要在自定义的servlet上用@Controller("映射路径")标注即可>
     * </p>
     *
     * @return
     */
    @Bean
    public HandlerAdapter servletHandlerAdapter() {
        logger.info("HandlerAdapter");
        return new SimpleServletHandlerAdapter();
    }

    /**
     * 描述 : <基于cookie的本地化资源处理器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean(name = "localeResolver")
    public CookieLocaleResolver cookieLocaleResolver() {
        logger.info("CookieLocaleResolver");
        return new CookieLocaleResolver();
    }

    /**
     * 描述 : <RequestMappingHandlerMapping需要显示声明，否则不能注册自定义的拦截器>. <br>
     * <p>
     * <这个比较奇怪,理论上应该是不需要的>
     * </p>
     *
     * @return
     */
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        logger.info("RequestMappingHandlerMapping");

        return super.requestMappingHandlerMapping();
    }

    /**
     * 描述 : <添加拦截器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        logger.info("addInterceptors start");
        registry.addInterceptor(localeChangeInterceptor());
        registry.addInterceptor(initializingInterceptor());
        logger.info("addInterceptors end");
    }

    /**
     * 描述 : <本地化拦截器>. <br><--国际化操作拦截器 如果采用基于（请求/Session/Cookie）则必需配置 -->
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        logger.info("LocaleChangeInterceptor");
        return new LocaleChangeInterceptor();
    }

    /**
     * 描述 : <注册自定义拦截器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean
    public CP_InitializingInterceptor initializingInterceptor() {
        logger.info("CP_InitializingInterceptor");
        return new CP_InitializingInterceptor();
    }

    /**
     * 描述 : <HandlerMapping需要显示声明，否则不能注册资源访问处理器>. <br>
     * <p>
     * <这个比较奇怪,理论上应该是不需要的>  不重载该方法，无法注册资源访问器，所有的静态资源如图片，js脚本都无法访问
     * </p>
     *
     * @return
     */
    @Bean
    public HandlerMapping resourceHandlerMapping() {
        logger.info("HandlerMapping");
        return super.resourceHandlerMapping();
    }

    /**
     * 描述 : <资源访问处理器>. <br>
     * <p>
     * <可以在jsp中使用/static/**的方式访问/WEB-INF/static/下的内容>
     * </p>
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("addResourceHandlers");
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
    }

    /**
     * 描述 : <RequestMappingHandlerAdapter需要显示声明，否则不能注册通用属性编辑器，如日期的转化器CP_PropertyEditorRegistrar>. <br>
     * <p>
     * <这个比较奇怪,理论上应该是不需要的>
     * </p>
     *
     * @return
     */
//    @Bean
//    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
//        logger.info("RequestMappingHandlerAdapter");
//        return super.requestMappingHandlerAdapter();
//    }

    /**
     * 描述 : <注册通用属性编辑器>. <br>
     * <p>
     * <这里只增加了字符串转日期和字符串两边去空格的处理>
     * </p>
     * 用于request中的参数类型自动转化， 如messageController date 的参数
     * @return
     */
    @Override
    protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer() {
        logger.info("ConfigurableWebBindingInitializer");
        ConfigurableWebBindingInitializer initializer = super.getConfigurableWebBindingInitializer();
        DatePropertyEditorRegistrar register = new DatePropertyEditorRegistrar();
        register.setFormat("yyyyMMdd");
        initializer.setPropertyEditorRegistrar(register);
        return initializer;
    }


    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(stringHttpMessageConverter());
        converters.add(mappingJackson2HttpMessageConverter());
        super.configureMessageConverters(converters);
    }

    @Bean(name = "stringHttpMessageConverter")
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", Charset.forName("UTF-8"))));
        return converter;
    }

    @Bean(name = "mappingJackson2HttpMessageConverter")
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        return messageConverter;
    }


    /**
     * 描述 : <文件上传处理器>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @return
     */
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver() {
        logger.info("CommonsMultipartResolver");
        return new CommonsMultipartResolver();
    }

    /**
     * 描述 : <异常处理器>. <br>
     * <p>
     * <系统运行时遇到指定的异常将会跳转到指定的页面>
     * </p>
     *
     * @return
     */
    @Bean(name = "exceptionResolver")
    public CustomerSimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        logger.info("CustomerSimpleMappingExceptionResolver");
        CustomerSimpleMappingExceptionResolver simpleMappingExceptionResolver = new CustomerSimpleMappingExceptionResolver();
        simpleMappingExceptionResolver.setDefaultErrorView("common_error");
        simpleMappingExceptionResolver.setExceptionAttribute("exception");
        Properties properties = new Properties();
        properties.setProperty("java.lang.RuntimeException", "common_error");
        properties.setProperty("java.lang.Throwable", "common_error");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        simpleMappingExceptionResolver.setOrder(-1);
        return simpleMappingExceptionResolver;
    }
}
