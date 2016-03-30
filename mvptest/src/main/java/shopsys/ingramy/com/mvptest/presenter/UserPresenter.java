package shopsys.ingramy.com.mvptest.presenter;

import shopsys.ingramy.com.mvptest.bean.UserBean;
import shopsys.ingramy.com.mvptest.model.IUserModel;
import shopsys.ingramy.com.mvptest.model.UserModel;
import shopsys.ingramy.com.mvptest.view.IUserView;

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
