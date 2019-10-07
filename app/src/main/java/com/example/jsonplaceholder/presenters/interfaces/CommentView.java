package com.example.jsonplaceholder.presenters.interfaces;

import com.example.jsonplaceholder.data.commensmodel.UserComment;
import com.example.mylibrary.MvpView;

import java.util.List;

public interface CommentView extends MvpView {

    public void displayComments(List<UserComment> list);
}
