package com.example.jsonplaceholder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.data.albumsmodel.UserAlbum;

import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder> {

    private static final String TAG = "AlbumsAdapter";
    private Context mContext;
    private List<UserAlbum> mList;

    public AlbumsAdapter(Context mContext, List<UserAlbum> list) {
        this.mContext = mContext;
        this.mList = list;
    }

    @NonNull
    @Override
    public AlbumsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_card, parent, false);
        AlbumsAdapter.ViewHolder viewHolder = new AlbumsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsAdapter.ViewHolder holder, int position) {
        UserAlbum album = mList.get(position);
        holder.albumName.setText(album.getTitle());


    }

    public void setmList(List<UserAlbum> mList) {
        this.mList = mList;
    }

    @Override
    public int getItemCount() {
        return (mList != null) ? mList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView albumName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            albumName = itemView.findViewById(R.id.album_name);

            itemView.setOnClickListener(v -> {

            });
        }
    }
}
