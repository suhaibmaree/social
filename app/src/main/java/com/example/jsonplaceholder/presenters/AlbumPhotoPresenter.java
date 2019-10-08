package com.example.jsonplaceholder.presenters;

import com.example.jsonplaceholder.data.DataManager;
import com.example.jsonplaceholder.data.photosmodel.AlbumsPhoto;
import com.example.jsonplaceholder.presenters.interfaces.PhotoView;
import com.example.mylibrary.BasePresenter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AlbumPhotoPresenter extends BasePresenter<PhotoView> {


    public void getPhotos(String id) {
        DataManager manager = DataManager.getInstance();

        manager.getPhotos(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<AlbumsPhoto>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<AlbumsPhoto> list) {

                        mMvpView.displayPhotos(list);
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
