package com.example.jsonplaceholder.presenters;

import com.example.jsonplaceholder.data.DataManager;
import com.example.jsonplaceholder.data.albumsmodel.UserAlbum;
import com.example.jsonplaceholder.presenters.interfaces.AlbumView;
import com.example.mylibrary.BasePresenter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserAlbumsPresenter extends BasePresenter<AlbumView> {

    public void getAlbums(String id){

        DataManager manager = DataManager.getInstance();

        manager.getAlbums(id).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<List<UserAlbum>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<UserAlbum> list) {

                        mMvpView.displayAlbum(list);
                    }

                    @Override
                    public void onError(Throwable e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
