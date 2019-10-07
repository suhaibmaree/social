package com.example.jsonplaceholder.views.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.Adapters.PostsAdapter;
import com.example.jsonplaceholder.Adapters.UserAdapter;
import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.data.postsmodel.UserPost;
import com.example.jsonplaceholder.presenters.UserPostPresenter;
import com.example.jsonplaceholder.presenters.interfaces.PostView;
import com.example.jsonplaceholder.views.MainActivity;

import java.util.List;

public class PostsFragment extends Fragment implements PostView {

    private int id;
    private int page;
    private String title;
    private UserPostPresenter mPresenter;
    private RecyclerView mRecycler;
    private PostsAdapter mAdapter;
    private static final String TAG = "PostsFragment";


    public static PostsFragment newInstance(int page, String title, int id) {

        PostsFragment fragment = new PostsFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title", title);
        args.putInt("id", id);
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        page = getArguments().getInt("page");
        id = getArguments().getInt("id", 0);
        title = getArguments().getString("title");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        initialPresenter(String.valueOf(id), this);


        return view;

    }


    private void initialPresenter(String id, PostView v) {

        mPresenter = new UserPostPresenter();
        mPresenter.getUsers(id);
        mPresenter.attachView(v);

    }


    @Override
    public void displayPosts(List<UserPost> posts) {

        Log.d(TAG, "posts size: " + posts.size());
        initialRecycler(posts);

    }

    private void initialRecycler(List<UserPost> posts) {
        mRecycler = getView().findViewById(R.id.posts_recycler);
        mAdapter = new PostsAdapter(getView().getContext() , posts);
        mRecycler.setLayoutManager(new LinearLayoutManager(getView().getContext()));
        mAdapter.setmList(posts);
        mRecycler.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.detachView();
    }
}
