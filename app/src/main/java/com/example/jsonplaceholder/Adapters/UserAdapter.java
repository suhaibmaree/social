package com.example.jsonplaceholder.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.R;
import com.example.jsonplaceholder.data.usermodel.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private static final String TAG = "UserAdapter";
    private Context mContext;
    private List<UserModel> mList = new ArrayList<>();

    public UserAdapter(Context mContext, List<UserModel> list) {
        this.mContext = mContext;
        this.mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UserModel model = mList.get(position);

        holder.mName.setText(model.getName());
        holder.mUserName.setText(model.getUsername());
        holder.mEmail.setText(model.getEmail());
        holder.mId.setText("ID: "+model.getId().toString());

    }

    public void setmList(List<UserModel> mList) {
        this.mList = mList;
    }

    @Override
    public int getItemCount() {
        return (mList != null) ? mList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mName;
        private TextView mUserName;
        private TextView mEmail;
        private TextView mId;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mUserName = itemView.findViewById(R.id.username);
            mEmail = itemView.findViewById(R.id.username);
            mId = itemView.findViewById(R.id.id);

        }
    }
}
