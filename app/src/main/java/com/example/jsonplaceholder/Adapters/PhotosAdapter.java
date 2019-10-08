package com.example.jsonplaceholder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.data.photosmodel.AlbumsPhoto;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {

    private static final String TAG = "PhotosAdapter";
    private Context mContext;
    private List<AlbumsPhoto> mList;

    public PhotosAdapter(Context mContext, List<AlbumsPhoto> list) {
        this.mContext = mContext;
        this.mList = list;
    }

    @NonNull
    @Override
    public PhotosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_card, parent, false);
        PhotosAdapter.ViewHolder viewHolder = new PhotosAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosAdapter.ViewHolder holder, int position) {
        AlbumsPhoto photo = mList.get(position);
        holder.mTitle.setText(photo.getTitle());

        Glide.with(mContext).
                load(photo.getUrl()).
                placeholder(R.drawable.ic_insert_photo).
                into(holder.mImage);

    }


    public void setmList(List<AlbumsPhoto> mList) {
        this.mList = mList;
    }

    @Override
    public int getItemCount() {
        return (mList != null) ? mList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImage;
        public TextView mTitle;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.photo_title);
            mImage = itemView.findViewById(R.id.card_image);
        }
    }
}
