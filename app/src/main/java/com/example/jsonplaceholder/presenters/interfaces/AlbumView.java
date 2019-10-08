package com.example.jsonplaceholder.presenters.interfaces;

import com.example.jsonplaceholder.data.albumsmodel.UserAlbum;
import com.example.mylibrary.MvpView;

import java.util.List;

public interface AlbumView extends MvpView {

    void displayAlbum(List<UserAlbum> list);
}
