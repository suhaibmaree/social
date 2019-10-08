package com.example.jsonplaceholder.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jsonplaceholder.Adapters.UserAdapter;
import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.data.usermodel.UserModel;
import com.example.jsonplaceholder.presenters.UserPresenter;
import com.example.jsonplaceholder.presenters.interfaces.UserView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements UserView {

    private static final String TAG = "MainActivity";

    private UserPresenter userPresenter;
    private UserAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @BindView(R.id.swiperefresh)  SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.users_indicator)  ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initPresenter();
        loadData();
        refresh();

    }// end onCreate


    private void refresh() {
        mSwipeRefreshLayout.setOnRefreshListener(() -> {

            loadData();
            mSwipeRefreshLayout.setRefreshing(false);

        });
    }

    private void loadData() {
        mProgressBar.setVisibility(View.VISIBLE);
        userPresenter.getUsers();

    }

    private void initPresenter() {

        Log.d(TAG, "Initial presenter");
        userPresenter = new UserPresenter();
    }

    @Override
    public void displayUsers(List<UserModel> userList) {

        Log.d(TAG, "My list size: " + userList.size());
        initialRecyclerView(userList);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayError(Throwable e) {
        CharSequence msg = "Sth went wrong";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        mProgressBar.setVisibility(View.GONE);

    }

    private void initialRecyclerView(List<UserModel> list) {
        mRecyclerView = findViewById(R.id.user_recycler);
        mAdapter = new UserAdapter(MainActivity.this, list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setmList(list);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
        userPresenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        userPresenter.detachView();
    }
}
