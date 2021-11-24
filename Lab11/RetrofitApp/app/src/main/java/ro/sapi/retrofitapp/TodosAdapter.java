package ro.sapi.retrofitapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.CustomViewHolder> {
    private List<Todo> dataList;
    private Context context;

    public TodosAdapter(Context context,List<Todo> dataList){
        this.context = context;
        this.dataList = dataList;
    }
    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView userId;
        TextView title2;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            userId = mView.findViewById(R.id.userId);
            title2 = mView.findViewById(R.id.title2);
        }
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row2, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.title2.setText(dataList.get(position).getTitle());
        holder.userId.setText(dataList.get(position).getId());
        //holder.completed.setText(dataList.get(position).getCompleted().toString());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
