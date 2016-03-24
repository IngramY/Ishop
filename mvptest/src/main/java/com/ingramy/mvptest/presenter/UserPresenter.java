package com.ingramy.mvptest.presenter;

import com.ingramy.mvptest.bean.UserBean;
import com.ingramy.mvptest.model.IUserModel;
import com.ingramy.mvptest.model.UserModel;
import com.ingramy.mvptest.view.IUserView;

public class UserPresenter {
    private IUserView mUserView;
    private IUserModel mUserModel;

    public UserPresenter(IUserView view) {
        mUserView = view;
        mUserModel = new UserModel();
    }

    public void saveUser(int id, String firstName, String lastName) {
        mUserModel.setID(id);
        mUserModel.setFirstName(firstName);
        mUserModel.setLastName(lastName);
    }

    public void loadUser(int id) {
        UserBean user = mUserModel.load(id);
        mUserView.setFirstName(user.getFirstName()); // 通过调用IUserView的方法来更新显示
        mUserView.setLastName(user.getLastName());
    }


}
