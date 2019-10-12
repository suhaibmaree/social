package com.example.jsonplaceholder.views.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.Adapters.AlbumsAdapter;
import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.data.albumsmodel.UserAlbum;
import com.example.jsonplaceholder.presenters.UserAlbumsPresenter;
import com.example.jsonplaceholder.presenters.interfaces.AlbumView;

import java.util.List;

public class AlbumsFragment extends Fragment implements AlbumView {

    private static final String TAG = "AlbumsFragment";
    private int id;
    private int page;
    private String title;
    private ProgressBar mProgress;
    private UserAlbumsPresenter mPresenter;

    RecyclerView mRecycler;

    private AlbumsAdapter mAdapter;


    public static AlbumsFragment newInstance(int page, String title, int id) {

        AlbumsFragment fragment = new AlbumsFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);//put keys as constants
        args.putString("title", title);
        args.putInt("id", id);
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        page = getArguments().getInt("page");
        id = getArguments().getInt("id" , 0);
        title = getArguments().getString("title");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {

        View view = inflater.inflate(R.layout.fragment_albums, container , false);
        mProgress = view.findViewById(R.id.album_indicator);//use butterknife instead
        initialPresenter();

        return view;

    }

    private void initialPresenter() {

        mProgress.setVisibility(View.VISIBLE);
        mPresenter = new UserAlbumsPresenter();
        mPresenter.getAlbums(String.valueOf(id));

    }

    @Override
    public void displayAlbum(List<UserAlbum> list) {

        Log.d(TAG , "user id "+id+" album is: " + list.size());
        initialRecycler(list);
    }

    private void initialRecycler(List<UserAlbum> album) {
        mRecycler = getView().findViewById(R.id.album_recycler);
        mAdapter = new AlbumsAdapter(getView().getContext() ,album);
        mRecycler.setLayoutManager(new LinearLayoutManager(getView().getContext()));
        mAdapter.setmList(album);
        mRecycler.setAdapter(mAdapter);
        mProgress.setVisibility(View.INVISIBLE);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        mPresenter.attachView(this);
        super.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.detachView();
        super.onStop();
    }
}
