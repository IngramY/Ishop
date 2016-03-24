package com.ingramy.mvptest.bean;

public class UserBean {
    private int mId;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    private String mFirstName;
    private String mLastName;

    public UserBean() {
    }

    public UserBean(String firstName, String lastName) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }
}