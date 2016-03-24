package com.ingramy.mvptest.model;

import com.ingramy.mvptest.bean.UserBean;

/**
 * Created by ycw on 2016/3/24.
 */
public class UserModel implements IUserModel {
    private UserBean userBean = new UserBean();

    @Override
    public void setID(int id) {
        userBean.setId(id);
    }

    @Override
    public void setFirstName(String firstName) {
        userBean.setFirstName(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        userBean.setLastName(lastName);
    }

    @Override
    public UserBean load(int id) {
        if (id == userBean.getId()) {
            return userBean;
        }
        return new UserBean("", "");
    }

}
