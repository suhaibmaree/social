package com.example.jsonplaceholder.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.jsonplaceholder.Adapters.UserAdapter;
import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.data.usermodel.UserModel;
import com.example.jsonplaceholder.presenters.UserPresenter;
import com.example.jsonplaceholder.presenters.UserView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UserView {

    private static final String TAG = "MainActivity";
    private UserPresenter userPresenter;
    private UserAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPresenter();
        loadData();

    }// end onCreate

    private void loadData() {

        userPresenter.getUsers();
    }

    private void initPresenter() {

        Log.d(TAG, "Initial presenter");
        userPresenter = new UserPresenter();
        userPresenter.attachView(this);
    }

    @Override
    public void displayUsers(List<UserModel> userList) {

        Log.d(TAG , "My list size: "+userList.size());
        initialRecyclerView(userList);
    }

    private void initialRecyclerView(List<UserModel> list) {
        mRecyclerView = findViewById(R.id.user_recycler);
        mAdapter = new UserAdapter(MainActivity.this , list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setmList(list);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        super.onStop();
        userPresenter.detachView();
    }
}
