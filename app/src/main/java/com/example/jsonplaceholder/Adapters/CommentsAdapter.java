package com.example.jsonplaceholder.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.data.commensmodel.UserComment;
import com.example.jsonplaceholder.views.CommentsActivity;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private static final String TAG = "CommentsAdapter";
    private Context mContext;
    private List<UserComment> mList;

    public CommentsAdapter(Context mContext, List<UserComment> list) {
        this.mContext = mContext;
        this.mList = list;
    }

    @NonNull
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_card, parent, false);
        CommentsAdapter.ViewHolder viewHolder = new CommentsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.ViewHolder holder, int position) {
        UserComment comment = mList.get(position);
        holder.mName.setText(comment.getName());
        holder.mCommentBody.setText(comment.getBody());
    }


    public void setmList(List<UserComment> mList) {
        this.mList = mList;
    }

    @Override
    public int getItemCount() {
        return (mList != null) ? mList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mName;
        public TextView mCommentBody;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.comment_name);
            mCommentBody = itemView.findViewById(R.id.comment_body);

            itemView.setOnClickListener(v -> {
                CommentsActivity.startCommentActivity((Activity) itemView.getContext(),
                        mList.get(getAdapterPosition()).getId());
            });
        }
    }
}
