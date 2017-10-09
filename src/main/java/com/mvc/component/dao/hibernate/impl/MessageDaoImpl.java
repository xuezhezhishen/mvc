package com.mvc.component.dao.hibernate.impl;

import com.mvc.component.dao.MessageDao;
import com.mvc.component.dao.UserInfoDao;
import com.mvc.entity.Message;
import com.mvc.entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("messageDao")
public class MessageDaoImpl implements MessageDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Message> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Message").list();
    }

    @Override
    public String save(Message message) {
        Session session = sessionFactory.getCurrentSession();
        return session.save(message).toString();
    }
}
