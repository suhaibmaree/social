package com.example.jsonplaceholder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.data.postsmodel.UserPost;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private static final String TAG = "PostsAdapter";
    private Context mContext;
    private List<UserPost> mList;

    public PostsAdapter(Context mContext, List<UserPost> list) {
        this.mContext = mContext;
        this.mList = list;
    }

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_card, parent, false);
        PostsAdapter.ViewHolder viewHolder = new PostsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UserPost post = mList.get(position);
        holder.mTitle.setText(post.getTitle());
        holder.mBody.setText(post.getBody());
    }

    public void setmList(List<UserPost> mList) {
        this.mList = mList;
    }

    @Override
    public int getItemCount() {
        return (mList != null) ? mList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        private TextView mBody;
        private RecyclerView mCommentRecycler;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.comment_title);
            mBody = itemView.findViewById(R.id.comment_body);
            mCommentRecycler = itemView.findViewById(R.id.comment_recycler);


        }
    }
}
