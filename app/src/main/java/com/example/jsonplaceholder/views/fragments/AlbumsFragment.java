package com.example.jsonplaceholder.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.jsonplaceholder.R;

public class AlbumsFragment extends Fragment {

    private int id;
    private int page;
    private String title;


    public static AlbumsFragment newInstance(int page, String title, int id) {

        AlbumsFragment fragment = new AlbumsFragment();
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
        id = getArguments().getInt("id" , 0);
        title = getArguments().getString("title");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {

        View view = inflater.inflate(R.layout.fragment_albums, container , false);
        TextView textView =view.findViewById(R.id.album_text);
        textView.setText("Album for user id: " + id);
        return view;

    }
}
