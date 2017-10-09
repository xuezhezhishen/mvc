//package com.mvc.controller;
//
//import com.mvc.dto.TestVO;
//import com.mvc.service.MessageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.i18n.CookieLocaleResolver;
//import org.springframework.web.servlet.support.RequestContext;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Date;
//import java.util.Locale;
//
///**
// * Created by kage on 2017/7/14.
// */
//@Controller
//public class MessageController {
//
//    @Resource
//    private MessageService messageService;
//
//    @Autowired
//    private CookieLocaleResolver localeResolver;
//    @RequestMapping("/user/message/list")
//    public String message(HttpServletRequest request, HttpServletResponse response,
//                          Model model, @RequestParam(value="langType", defaultValue="zh") String langType,
//                          @RequestParam(value="date")Date date){
//
//        System.out.println(date);
//        if(!model.containsAttribute("contentModel")){
//
//            /*if(langType.equals("zh")){
//                Locale locale = new Locale("zh", "CN");
//                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
//            }
//            else if(langType.equals("en")){
//                Locale locale = new Locale("en", "US");
//                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
//            }
//            else
//                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());*/
//
//            if(langType.equals("zh")){
//                Locale locale = new Locale("zh", "CN");
//                //request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
//                localeResolver.setLocale (request, response, locale);
//            }
//            else if(langType.equals("en")){
//                Locale locale = new Locale("en", "US");
//                //request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
//                localeResolver.setLocale (request, response, locale);
//            }
//            else
//                //request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());
//                localeResolver.setLocale (request, response, LocaleContextHolder.getLocale());
//
//            //从后台代码获取国际化信息
//            RequestContext requestContext = new RequestContext(request);
//            model.addAttribute("money", requestContext.getMessage("money"));
//            model.addAttribute("date", requestContext.getMessage("date"));
//
//
//            TestVO formatModel=new TestVO();
//
//            formatModel.setMoney("12345.678");
//            formatModel.setDate(new Date());
//
//            model.addAttribute("contentModel", formatModel);
//        }
//
//        messageService.findAll();
//        return "/usermanage/message-add";
//    }
//
//
//
//
//}
