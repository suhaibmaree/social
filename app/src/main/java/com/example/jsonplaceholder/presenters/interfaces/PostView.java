package com.example.jsonplaceholder.presenters.interfaces;

import com.example.jsonplaceholder.data.postsmodel.UserPost;
import com.example.mylibrary.MvpView;

import java.util.List;

public interface PostView extends MvpView {

    void displayPosts(List<UserPost> posts);
}
