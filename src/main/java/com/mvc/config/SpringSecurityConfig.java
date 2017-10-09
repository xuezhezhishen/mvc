//package com.mvc.config;
//
//import com.mvc.interrupt.CommonSecurityFilter;
//import com.mvc.component.service.CustomerUserDetailsService;
//import org.apache.log4j.Logger;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.AccessDecisionManager;
//import org.springframework.security.access.AccessDecisionVoter;
//import org.springframework.security.access.vote.AffirmativeBased;
//import org.springframework.security.access.vote.AuthenticatedVoter;
//import org.springframework.security.access.vote.RoleVoter;
//import org.springframework.security.authentication.event.LoggerListener;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
//import org.springframework.security.web.access.expression.WebExpressionVoter;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Spencer.hong on 2017/6/16.
// */
//@Configuration
//@EnableWebMvcSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private static final Logger logger = Logger
//        .getLogger(SpringSecurityConfig.class);
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//        throws Exception {
//
//        // 自定义UserDetailsService
////        auth.userDetailsService(userDetailsService()).passwordEncoder(
////            new Md5PasswordEncoder());
//        // 不适用加密才能在userDetailsService 使用密码明文
//        auth.userDetailsService(userDetailsService());
//
//    }
//
//    @Bean
//    public CustomerUserDetailsService userDetailsService() {
//        logger.info("CustomerUserDetailsService");
//        CustomerUserDetailsService userDetailsService = new CustomerUserDetailsService();
//        return userDetailsService;
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // 设置不拦截规则
//        web.ignoring().antMatchers("/static/**", "/**/*.jsp");
//
//    }
//   public CommonSecurityFilter commonSecurityFilter(){
//       CommonSecurityFilter commonSecurityFilter = new CommonSecurityFilter();
//       return  commonSecurityFilter;
//   }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        // 自定义拦截规则
//        http.authorizeRequests().accessDecisionManager(accessDecisionManager())
//                .expressionHandler(webSecurityExpressionHandler())
//                .antMatchers("/normal/**").permitAll()
//                .antMatchers("/").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/j_spring_security_check").hasRole("USER")
//
//                // 登录失败的拒绝页面
//                .and().exceptionHandling().accessDeniedPage("/login");
//
//        //        // 自定义登录页面
//        http.csrf().disable().formLogin().loginPage("/normal/login")
//            .failureUrl("/normal/login?error=1")
//            .loginProcessingUrl("/j_spring_security_check")
//                .successForwardUrl("/user/login-submit")
//            .usernameParameter("j_username")
//            .passwordParameter("j_password").permitAll();
////        // session管理 最大session 数,防止多用户同一个账号登录
////        http.sessionManagement().sessionFixation().changeSessionId()
////                .maximumSessions(1).maxSessionsPreventsLogin(true).expiredUrl("/normal/login");
//
//        // 设置拦截规则
//        // 自定义accessDecisionManager访问控制器,并开启表达式语言
////        http.authorizeRequests().accessDecisionManager(accessDecisionManager())
////            .expressionHandler(webSecurityExpressionHandler())
////            .antMatchers("/**/*.do*").hasRole("USER")
////            .antMatchers("/**/*.htm").hasRole("ADMIN").and()
////            .exceptionHandling().accessDeniedPage("/login");
////        http.addFilter(commonSecurityFilter());
//
////        new BasicAuthenticationEntryPoint().
////        // 最简单配置 使用自带登录界面
////        http.authorizeRequests() .antMatchers("/login")
////                .permitAll().antMatchers("/**").hasRole("USER")
////            .antMatchers("/admin/*").hasRole("ADMIN");
////        // 开启默认登录页面
////         http.formLogin();
////        http.csrf().disable();
////        http.rememberMe();
//
////
//
////
////        // 自定义注销
//////        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
//////            .invalidateHttpSession(true);
////
//
////
////        // RemeberMe
////        http.rememberMe().key("webmvc#FD637E6D9C0F1A5A67082AF56CE32485");
//
//    }
//
//    /*
//     *
//     * 这里可以增加自定义的投票器
//     */
//    @SuppressWarnings("rawtypes")
//    @Bean(name = "accessDecisionManager")
//    public AccessDecisionManager accessDecisionManager() {
//        logger.info("AccessDecisionManager");
//        List<AccessDecisionVoter<? extends Object>> decisionVoters =
//            new ArrayList<AccessDecisionVoter<? extends Object>>();
//        decisionVoters.add(new RoleVoter());
//        decisionVoters.add(new AuthenticatedVoter());
//        decisionVoters.add(webExpressionVoter());// 启用表达式投票器
//
//        AffirmativeBased accessDecisionManager = new AffirmativeBased(
//            decisionVoters);
//
//        return accessDecisionManager;
//    }
//
//    /*
//     * 表达式控制器
//     */
//    @Bean(name = "expressionHandler")
//    public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
//        logger.info("DefaultWebSecurityExpressionHandler");
//        DefaultWebSecurityExpressionHandler webSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
//        return webSecurityExpressionHandler;
//    }
//
//    /*
//     * 表达式投票器
//     */
//    @Bean(name = "expressionVoter")
//    public WebExpressionVoter webExpressionVoter() {
//        logger.info("WebExpressionVoter");
//        WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
//        webExpressionVoter.setExpressionHandler(webSecurityExpressionHandler());
//        return webExpressionVoter;
//    }
//
//    @Bean
//    public LoggerListener loggerListener() {
//        logger.info("org.springframework.security.authentication.event.LoggerListener");
//        LoggerListener loggerListener = new LoggerListener();
//
//        return loggerListener;
//    }
//
//    @Bean
//    public org.springframework.security.access.event.LoggerListener eventLoggerListener() {
//        logger.info("org.springframework.security.access.event.LoggerListener");
//        org.springframework.security.access.event.LoggerListener eventLoggerListener = new org.springframework.security.access.event.LoggerListener();
//
//        return eventLoggerListener;
//    }
//
//}