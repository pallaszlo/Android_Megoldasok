package com.example.mytodoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TaskAdapter2 extends ArrayAdapter<Task> {
    private Context context;
    private List<Task> tasks;
    public TaskAdapter2(@NonNull Context context, List<Task> tasks) {
        super(context, 0, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        // referenciak kinyerese
        CheckBox checkBox = convertView.findViewById(R.id.checkboxTask);
        TextView taskName = convertView.findViewById(R.id.textviewTaskName);
        TextView priority = convertView.findViewById(R.id.textviewPriority);
        ImageView deleteBtn = convertView.findViewById(R.id.buttonDelete);



        // adatbetoltes
        Task task = tasks.get(position);

        taskName.setText(task.getName());
        priority.setText(task.getPriority());
        int priorityColor = getPriorityColor(task.getPriority());
        priority.setTextColor(priorityColor);
        checkBox.setChecked(task.isCompleted());

        return convertView;
    }

    private int getPriorityColor(String priority) {
        switch (priority) {
            case "Magas":
                return context.getResources().getColor(android.R.color.holo_red_light);
            case "Kozepes":
                return context.getResources().getColor(android.R.color.holo_orange_light);
            case "Alacsony":
                return context.getResources().getColor(android.R.color.holo_green_light);
            default:
                return context.getResources().getColor(android.R.color.black);
        }
    }
}
