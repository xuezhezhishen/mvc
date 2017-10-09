package com.mvc.service;

import com.mvc.entity.Message;
import com.mvc.entity.UserInfo;

import java.util.List;

/**
 * Created by kage on 2017/7/14.
 */
public interface MessageService {

    public String save(Message message);
    public List<Message> findAll();
}
