package com.ingramy.mvptest.model;

import com.ingramy.mvptest.bean.UserBean;

public interface IUserModel {
    void setID(int id);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    UserBean load(int id);// 通过id读取user信息,返回一个UserBean
}