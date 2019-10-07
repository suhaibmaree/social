package com.example.jsonplaceholder.presenters;

import android.util.Log;

import com.example.jsonplaceholder.data.DataManager;
import com.example.jsonplaceholder.data.postsmodel.UserPost;
import com.example.jsonplaceholder.data.usermodel.UserModel;
import com.example.jsonplaceholder.presenters.interfaces.PostView;
import com.example.jsonplaceholder.presenters.interfaces.UserView;
import com.example.mylibrary.BasePresenter;
import com.example.mylibrary.MvpView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserPostPresenter extends BasePresenter<PostView> {

    private static final String TAG = "UserPresenter";
    private Disposable mDisposable;

    public void getUsers(String id) {

        Log.d(TAG, "Initial data manager");

        DataManager manager = DataManager.getInstance();

        manager.getPosts(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UserPost>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        mDisposable = d;
                    }

                    @Override
                    public void onNext(List<UserPost> posts) {
                        mMvpView.displayPosts(posts);
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
