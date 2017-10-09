//package com.mvc.dao.hibernate.impl;
//
//import com.mvc.dao.UserInfoDao;
//import com.mvc.entity.UserInfo;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository("userInfoDao")
//public class UserInfoDaoImpl implements UserInfoDao{
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//
//    @Override
//    public UserInfo findUserInfoByName(String name) {
//        Session session = sessionFactory.getCurrentSession();
//        List<UserInfo> userInfos =  session.createQuery(" from UserInfo where userName='"+name+"'").setCacheable(true).list();
//        UserInfo user= session.get(UserInfo.class, Integer.valueOf(1));
//        UserInfo user2= session.get(UserInfo.class, Integer.valueOf(1));
//        List<UserInfo> userInfos2 =  session.createQuery(" from UserInfo where userName='"+name+"'").setCacheable(true).list();
//        if(userInfos.size() > 0){
//            return userInfos.get(0);
//        }
//
//
//        return null;
//    }
//
//    public String save(UserInfo userInfo){
//        Session session = sessionFactory.getCurrentSession();
//
//        return session.save(userInfo).toString();
//    }
//}
