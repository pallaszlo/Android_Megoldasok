package com.example.myrecyclerview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.VH>{
    private Activity context;
    private List<Contact> contacts;

    public ContactsAdapter(Activity context, List<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listRow = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_row, parent, false);
        return new VH(listRow, context);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Contact contact = contacts.get(position);
        holder.name.setText(contact.getName());
        holder.image.setImageResource(contact.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class VH extends RecyclerView.ViewHolder{
        View rootView;
        ImageView image;
        TextView name;

        public VH(View view, Context context){
            super(view);
            rootView = view;
            image = rootView.findViewById(R.id.image);
            name = rootView.findViewById(R.id.name);
        }
    }
}
