package com.example.jsonplaceholder.api;

import com.example.jsonplaceholder.data.usermodel.UserModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UsersService {

    @GET("/users")
    Observable<List<UserModel>> getUsers();
}
