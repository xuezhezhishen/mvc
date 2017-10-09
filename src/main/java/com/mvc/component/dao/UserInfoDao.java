package com.mvc.component.dao;

import com.mvc.entity.UserInfo;


public interface UserInfoDao {
    public UserInfo findUserInfoByName(String name);
    public String save(UserInfo userInfo);
}
