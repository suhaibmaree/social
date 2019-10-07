package com.example.jsonplaceholder.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.jsonplaceholder.Adapters.CommentsAdapter;
import com.example.jsonplaceholder.Adapters.PostsAdapter;
import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.data.commensmodel.UserComment;
import com.example.jsonplaceholder.data.postsmodel.UserPost;
import com.example.jsonplaceholder.presenters.PostCommentsPresenter;
import com.example.jsonplaceholder.presenters.interfaces.CommentView;

import java.util.List;

public class CommentsActivity extends AppCompatActivity  implements CommentView {

    private static final String TAG = "CommentsActivity";
    private PostCommentsPresenter mPresenter;
    private int id;
    private RecyclerView mRecycler;
    private CommentsAdapter mAdapter;

    public static void startCommentActivity(Activity source , int id){

        Intent intent = new Intent(source , CommentsActivity.class);
        intent.putExtra("id" , id);
        source.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        Intent intent = getIntent();
        id = intent.getIntExtra("id" , 0);
        initialPresenter();

    }

    private void initialPresenter() {
        mPresenter = new PostCommentsPresenter();
        mPresenter.getComments(String.valueOf(id));
    }


    @Override
    public void displayComments(List<UserComment> list) {

        Log.d(TAG , "comment list size: " + list.size() + " for post: "+ id);

        initialRecycler(list);

    }

    private void initialRecycler(List<UserComment> posts) {
        mRecycler = findViewById(R.id.comment_recycler);
        mAdapter = new CommentsAdapter(this, posts);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setmList(posts);
        mRecycler.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onStart() {
        mPresenter.attachView(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        mPresenter.detachView();
        super.onStop();
    }
}
