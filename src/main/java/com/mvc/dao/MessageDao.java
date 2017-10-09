package com.mvc.dao;

import com.mvc.entity.Message;
import com.mvc.entity.UserInfo;

import java.util.List;


public interface MessageDao {
    public List<Message> findAll();
    public String save(Message message);
}
