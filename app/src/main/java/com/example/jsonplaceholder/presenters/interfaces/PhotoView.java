package com.example.jsonplaceholder.presenters.interfaces;

import com.example.jsonplaceholder.data.photosmodel.AlbumsPhoto;
import com.example.mylibrary.MvpView;

import java.util.List;

public interface PhotoView extends MvpView {

    void displayPhotos(List<AlbumsPhoto> list);
}
