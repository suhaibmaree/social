package com.example.jsonplaceholder.data;

import android.util.Log;

import com.example.jsonplaceholder.api.PostCommentsService;
import com.example.jsonplaceholder.api.UsersClient;
import com.example.jsonplaceholder.api.UsersPostsService;
import com.example.jsonplaceholder.api.UsersService;
import com.example.jsonplaceholder.data.commensmodel.UserComment;
import com.example.jsonplaceholder.data.postsmodel.UserPost;
import com.example.jsonplaceholder.data.usermodel.UserModel;

import java.util.List;

import io.reactivex.Observable;

public class DataManager {

    private static DataManager manager;

    private static final String TAG = "DataManager";

    public static DataManager getInstance() {
        if (manager == null) {
            manager = new DataManager();
        }
        return manager;
    }

    public Observable<List<UserModel>> getUsers() {

        Log.d(TAG , "initial user client");
        return UsersClient.getUsers().create(UsersService.class).getUsers();
    }

    public Observable<List<UserPost>> getPosts(String id) {

        Log.d(TAG , "initial user posts client");
        return UsersClient.getUsers().create(UsersPostsService.class).getUserPosts(id);
    }

    public Observable<List<UserComment>> getComments(String id) {

        Log.d(TAG , "initial user posts client");
        return UsersClient.getUsers().create(PostCommentsService.class).getComments(id);
    }

}
