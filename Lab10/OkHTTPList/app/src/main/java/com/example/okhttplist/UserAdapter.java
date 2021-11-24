package com.example.okhttplist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{

    private Context context ;
    private List<User> userList ;


    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView avatar;
        TextView firstName;
        TextView lastName;
        TextView email;
        public MyViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.firstName) ;
            lastName = itemView.findViewById(R.id.lastName);
            email = itemView.findViewById(R.id.email) ;
            avatar = itemView.findViewById(R.id.avatar);
        }
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        User user = userList.get(position);
        Picasso.get().load(user.getAvatar()).into(holder.avatar);
        holder.firstName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        holder.email.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
