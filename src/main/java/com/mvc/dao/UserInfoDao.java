package com.mvc.dao;

import com.mvc.entity.UserInfo;
import org.springframework.stereotype.Repository;


public interface UserInfoDao {
    public UserInfo findUserInfoByName(String name);
    public String save(UserInfo userInfo);
}
