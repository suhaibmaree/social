package com.example.jsonplaceholder.api;

import com.example.jsonplaceholder.data.albumsmodel.UserAlbum;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsersAlbumsService {
    @GET("/albums")
    Observable<List<UserAlbum>> getAlbums(@Query("userId") String id);
}
