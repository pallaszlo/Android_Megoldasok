package com.example.photodiary;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.EntryViewHolder>{
    private List<DiaryEntry> entries = new ArrayList<>();
    private OnEntryClickListener clickListener;
    private OnEntryLongClickListener longClickListener;

    public interface OnEntryClickListener {
        void onEntryClick(DiaryEntry entry);
    }

    public interface OnEntryLongClickListener {
        void onEntryLongClick(DiaryEntry entry);
    }

    public EntryAdapter(OnEntryClickListener clickListener, OnEntryLongClickListener longClickListener) {
        this.clickListener = clickListener;
        this.longClickListener = longClickListener;
    }

    public void setEntries(List<DiaryEntry> entries){
        this.entries = entries;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public EntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diary_entry,
                parent, false);
        return new EntryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntryViewHolder holder, int position) {
        holder.bind(entries.get(position));
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    class EntryViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewPhoto;
        TextView textViewTitle;
        TextView textViewDate;
        TextView textViewPreview;
        public EntryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPhoto = itemView.findViewById(R.id.imageViewPhoto);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewPreview = itemView.findViewById(R.id.textViewPreview);
        }

        void bind(DiaryEntry entry) {
            textViewTitle.setText(entry.getTitle());
            textViewDate.setText(entry.getFormattedDate());
            textViewPreview.setText(entry.getContent());
            // Foto betoltese
            if (entry.hasPhoto()) {
                File imgFile = new File(entry.getPhotoPath());
                if (imgFile.exists()) {
                    imageViewPhoto.setImageBitmap(
                            BitmapFactory.decodeFile(imgFile.getAbsolutePath())
                    );
                }
            }
            // Rovid es hosszu kattintas
            itemView.setOnClickListener(v-> clickListener.onEntryClick(entry));
            itemView.setOnLongClickListener(v-> {
                longClickListener.onEntryLongClick(entry);
                return true;
            });
        }
    }
}
