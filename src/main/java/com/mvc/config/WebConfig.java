//package hello;
//
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.mvc.Controller;
//import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
//
///**
// * Created by Spencer.hong on 2017/6/16.
// */
//@Configuration
//@EnableWebMvc
////@ComponentScan(basePackages = {"hello"})
//@ComponentScan(basePackages = "hello", useDefaultFilters = false, includeFilters = {
//    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})
//})
//public class WebConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.enableContentNegotiation(new MappingJackson2JsonView());
//        registry.jsp();
//    }
//
//}
