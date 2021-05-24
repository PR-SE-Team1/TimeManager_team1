package com.example.timemanager.ui.recycler;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.tasks.Task;

import java.util.List;

/**
 * class used to create a recycler view of tasks displayed on taskscreen
 * these tasks open a new activity when clicked
 */
public class RecyclerViewAdapterTasks extends RecyclerView.Adapter<RecyclerViewAdapterTasks.ViewHolder> {

    Context context;
    private List<Task> data;
    private LayoutInflater inflater;
    private OnTaskListener onTaskListener;


    /**
     * constructor for a recycler view adapter
     * @param context
     * @param data
     * @param onTaskListener
     */
    public RecyclerViewAdapterTasks(Context context, List<Task> data, OnTaskListener onTaskListener){
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
        this.onTaskListener = onTaskListener;

    }

    @Override
    public RecyclerViewAdapterTasks.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) throws NullPointerException {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_item_view_tasks, parent, false);
        ViewHolder viewHolder = new ViewHolder(v, onTaskListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterTasks.ViewHolder holder, int position){
        //holder.textView.setText(data.get(position).getClass().getName());
        holder.taskName.setText(data.get(position).getTaskName());
    }


    @Override
    public int getItemCount() {
        return this.data.size();
    }

    /**
     * static class ViewHolder for different views (elements) of a recycler view
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView taskName;
        OnTaskListener onTaskListener;
        public ViewHolder(@NonNull View view, OnTaskListener onTaskListener) {
            super(view);
            taskName = (TextView) view.findViewById(R.id.name_task);
            view.setOnClickListener(this);
            this.onTaskListener = onTaskListener;
        }
        @Override
        public void onClick(View view) {
            onTaskListener.onTaskClick(getAdapterPosition());
            Toast.makeText(view.getContext(), "position : " + getLayoutPosition() + " text : " + this.taskName.getText(), Toast.LENGTH_SHORT).show();
            Toast.makeText(view.getContext(), "The Item Clicked is: "+getLayoutPosition(),Toast.LENGTH_SHORT).show();

        }
    }

    /**
     * interface to detect a click
     */
    public interface OnTaskListener{
        //used in the activity to send position of clicked item
        void onTaskClick(int position);
    }

}
