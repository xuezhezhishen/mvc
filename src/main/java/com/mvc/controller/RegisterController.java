package com.mvc.controller;

import com.mvc.dto.Message;
import com.mvc.entity.UserInfo;
import com.mvc.component.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kage on 2017/7/14.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/normal/register")
    public String register(){
        return "/common/user/register";
    }

    @ResponseBody
    @RequestMapping(value="/normal/register_submit", method= RequestMethod.POST)
    public Message registerSubmit(UserInfo userInfo){
        userInfoService.save(userInfo);
        Message message = new Message();
        return  message;
    }


}
