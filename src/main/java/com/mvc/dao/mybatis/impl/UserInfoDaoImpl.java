package com.mvc.dao.mybatis.impl;

import com.mvc.dao.UserInfoDao;
import com.mvc.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


public interface UserInfoDaoImpl  extends UserInfoDao{

    public UserInfo findUserInfoByName(@Param("name") String name);

}
