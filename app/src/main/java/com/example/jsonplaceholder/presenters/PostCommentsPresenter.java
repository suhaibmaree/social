package com.example.jsonplaceholder.presenters;

import android.util.Log;

import com.example.jsonplaceholder.data.DataManager;
import com.example.jsonplaceholder.data.commensmodel.UserComment;
import com.example.jsonplaceholder.data.postsmodel.UserPost;
import com.example.jsonplaceholder.presenters.interfaces.CommentView;
import com.example.mylibrary.BasePresenter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostCommentsPresenter extends BasePresenter<CommentView> {

    private static final String TAG = "PostCommentsPresenter";
    private Disposable mDisposable;


    public void getComments(String id) {

        Log.d(TAG, "Initial data manager");
        DataManager manager = DataManager.getInstance();

        manager.getComments(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UserComment>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        mDisposable = d;
                    }

                    @Override
                    public void onNext(List<UserComment> posts) {
                        mMvpView.displayComments(posts);
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
