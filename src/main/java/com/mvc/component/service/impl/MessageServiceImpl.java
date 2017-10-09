//package com.mvc.component.service.impl;
//
//import com.mvc.component.dao.MessageDao;
//import com.mvc.component.dao.UserInfoDao;
//import com.mvc.entity.Message;
//import com.mvc.entity.UserInfo;
//import com.mvc.component.service.MessageService;
//import com.mvc.component.service.UserInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * Created by kage on 2017/7/14.
// */
//@Service("messageService")
//public class MessageServiceImpl implements MessageService{
//
//    @Autowired
//    private MessageDao messageDao;
//
//    @Override
//    @Transactional
//    public String save(Message message) {
//        return messageDao.save(message);
//    }
//    @Transactional(propagation= Propagation.REQUIRED)
//    public List<Message> findAll(){
//
//        return messageDao.findAll();
//    }
//}
