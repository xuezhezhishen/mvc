package com.mvc.component.service;

import com.mvc.entity.UserInfo;

/**
 * Created by kage on 2017/7/14.
 */
public interface UserInfoService {

    public String save(UserInfo userInfo);
    public UserInfo findUserInfoByName(String name);
}
