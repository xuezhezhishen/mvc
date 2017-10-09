package com.mvc.service.impl;

import com.mvc.dao.UserInfoDao;
import com.mvc.entity.UserInfo;
import com.mvc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by kage on 2017/7/14.
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{

    @Resource
    private UserInfoDao userInfoDao;

//    @Resource(name="userInfoDaoImpl")
//    private UserInfoDao myUserInfoDao;

    @Override
    @Transactional
    public String save(UserInfo userInfo) {
        return userInfoDao.save(userInfo);
    }
    @Transactional
    public UserInfo findUserInfoByName(String name){
//        myUserInfoDao.findUserInfoByName(name);
        return userInfoDao.findUserInfoByName(name);
    }
}
