package com.example.jsonplaceholder.api;

import com.example.jsonplaceholder.data.commensmodel.UserComment;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostCommentsService {

    @GET("/comments")
    Observable<List<UserComment>> getComments(@Query("postId") String id);
}
