package com.example.jsonplaceholder.api;

import com.example.jsonplaceholder.data.postsmodel.UserPost;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsersPostsService {

    @GET("/posts")
    Observable<List<UserPost>> getUserPosts(@Query("userId") String id);
}
