package com.mvc.component.dao.mybatis.impl;

import com.mvc.component.dao.UserInfoDao;
import com.mvc.entity.UserInfo;
import org.apache.ibatis.annotations.Param;


public interface UserInfoDaoImpl  extends UserInfoDao{

    public UserInfo findUserInfoByName(@Param("name") String name);

}
