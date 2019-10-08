package com.example.jsonplaceholder.presenters;


import android.util.Log;

import com.example.jsonplaceholder.data.DataManager;
import com.example.jsonplaceholder.data.usermodel.UserModel;
import com.example.jsonplaceholder.presenters.interfaces.UserView;
import com.example.mylibrary.BasePresenter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserPresenter extends BasePresenter<UserView> {

    private static final String TAG = "UserPresenter";
    private Disposable mDisposable;

    public void getUsers() {

        Log.d(TAG, "Initial data manager");

        DataManager manager = DataManager.getInstance();

        manager.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UserModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        mDisposable = d;
                    }

                    @Override
                    public void onNext(List<UserModel> userModels) {
                        mMvpView.displayUsers(userModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                    e.printStackTrace();
                        mMvpView.displayError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


}
