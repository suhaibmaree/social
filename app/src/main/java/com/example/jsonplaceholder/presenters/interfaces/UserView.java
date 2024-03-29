package com.example.jsonplaceholder.presenters.interfaces;

import com.example.jsonplaceholder.data.usermodel.UserModel;
import com.example.mylibrary.MvpView;

import java.util.List;

public interface UserView extends MvpView {

    void displayUsers(List<UserModel> userList);

    void displayError(Throwable e);
}
