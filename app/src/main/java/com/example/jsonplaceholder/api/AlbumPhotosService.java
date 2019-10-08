package com.example.jsonplaceholder.api;

import com.example.jsonplaceholder.data.photosmodel.AlbumsPhoto;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlbumPhotosService {
    @GET("/photos")
    Observable<List<AlbumsPhoto>> getPhotos(@Query("albumId") String id);

}
