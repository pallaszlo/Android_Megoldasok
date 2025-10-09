package com.example.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListViewAdapter extends ArrayAdapter {
    private Activity context;
    private Integer[] images;
    private String[] names;
    private String[] infos;

    public CustomListViewAdapter(@NonNull Activity context, String[] names, String[] infos,
                                 Integer[] images) {
        super(context, R.layout.list_item, names);

        this.context = context;
        this.names = names;
        this.infos = infos;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item, null,true);

        TextView nev = rowView.findViewById(R.id.name);
        TextView leiras = rowView.findViewById(R.id.description);
        ImageView kep = rowView.findViewById(R.id.image);

        nev.setText(names[position]);
        leiras.setText(infos[position]);
        kep.setImageResource(images[position]);
        return rowView;
    }
}
