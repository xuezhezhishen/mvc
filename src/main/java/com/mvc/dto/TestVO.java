package com.mvc.dto;

import java.util.Date;

/**
 * Created by kage on 2017/8/1.
 */
public class TestVO {

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String money;
    private Date date;
}
