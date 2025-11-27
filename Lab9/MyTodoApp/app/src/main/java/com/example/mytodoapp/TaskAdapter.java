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

public class TaskAdapter extends ArrayAdapter<Task> {
    private Context context;
    private List<Task> tasks;

    private OnTaskActionListener listener;

    public interface OnTaskActionListener {
        void onTaskDeleted(Task task);

        void onTaskChecked(Task task, boolean isChecked);
    }

    public TaskAdapter(@NonNull Context context, List<Task> tasks, OnTaskActionListener listener) {
        super(context, 0, tasks);
        this.context = context;
        this.tasks = tasks;
        this.listener = listener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        Task task = tasks.get(position);

        // referenciak kinyerese
        CheckBox checkBox = convertView.findViewById(R.id.checkboxTask);
        TextView taskName = convertView.findViewById(R.id.textviewTaskName);
        TextView priority = convertView.findViewById(R.id.textviewPriority);
        ImageView deleteBtn = convertView.findViewById(R.id.buttonDelete);

        //adatok betoltese
        taskName.setText(task.getName());
        taskName.setAlpha(task.isCompleted() ? 0.5f : 1.0f);
        priority.setText(task.getPriority());
        int priorityColor = getPriorityColor(task.getPriority());
        priority.setTextColor(priorityColor);
        checkBox.setChecked(task.isCompleted());

        checkBox.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            task.setCompleted(isChecked);
            listener.onTaskChecked(task, isChecked);
            notifyDataSetChanged();
        }));

        deleteBtn.setOnClickListener(v -> {
            if (listener != null)
                listener.onTaskDeleted(task);
        });


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
