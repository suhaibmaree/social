package com.example.jsonplaceholder.data;

import android.util.Log;

import com.example.jsonplaceholder.api.UsersClient;
import com.example.jsonplaceholder.api.UsersService;
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
}
