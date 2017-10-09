package com.mvc.component.dao;

import com.mvc.entity.Message;

import java.util.List;


public interface MessageDao {
    public List<Message> findAll();
    public String save(Message message);
}
