package com.mvc.controller;

import com.mvc.component.service.UserInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by spencer.hong on 2017/6/28.
 */
@Controller
public class LoginController {

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = {"/normal/login", "/"})
    public String login() {
        return "/common/login/login";
    }

    @RequestMapping(value="/user/login-submit")
    public String loginSubmit(@RequestParam(value="j_username") String userName,
                              @RequestParam(value="j_password") String passWorld, HttpServletRequest request){
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        userInfoService.findUserInfoByName("hlb");
        return "/usermanage/usermanage";
//        DispatcherServlet
    }
}
