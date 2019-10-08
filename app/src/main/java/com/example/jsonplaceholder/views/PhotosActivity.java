package com.example.jsonplaceholder.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.jsonplaceholder.Adapters.PhotosAdapter;
import com.example.jsonplaceholder.Adapters.UserAdapter;
import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.data.photosmodel.AlbumsPhoto;
import com.example.jsonplaceholder.data.usermodel.UserModel;
import com.example.jsonplaceholder.presenters.AlbumPhotoPresenter;
import com.example.jsonplaceholder.presenters.interfaces.PhotoView;
import com.example.jsonplaceholder.utility.CalculateColumns;

import java.util.List;

public class PhotosActivity extends AppCompatActivity implements PhotoView {

    private String id;
    private static final String TAG = "PhotosActivity";
    private RecyclerView mRecyclerView;
    private ProgressBar mProgress;

    public static void startActivity(Activity source, String id) {

        Intent intent = new Intent(source, PhotosActivity.class);
        intent.putExtra("id", id);
        source.startActivity(intent);

    }


    private AlbumPhotoPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        mProgress = findViewById(R.id.photos_indicator);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        initialPresenter();
    }

    private void initialPresenter() {
        mProgress.setVisibility(View.VISIBLE);
        mPresenter = new AlbumPhotoPresenter();
        mPresenter.getPhotos(id);
    }

    @Override
    public void displayPhotos(List<AlbumsPhoto> list) {
        Log.d(TAG , "Photo list size: "+ list.size());
        initialRecyclerView(list);
    }

    private void initialRecyclerView(List<AlbumsPhoto> list) {

        int numColumns = CalculateColumns.getInstance().calculateNoOfColumns(this);

        mRecyclerView = findViewById(R.id.photos_recycler);
        PhotosAdapter mAdapter = new PhotosAdapter(this, list);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, numColumns);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter.setmList(list);
        mRecyclerView.setAdapter(mAdapter);
        mProgress.setVisibility(View.INVISIBLE);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mProgress.setVisibility(View.VISIBLE);
        mPresenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.detachView();
    }
}
