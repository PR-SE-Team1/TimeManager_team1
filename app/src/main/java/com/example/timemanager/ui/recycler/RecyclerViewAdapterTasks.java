package com.example.timemanager.ui.recycler;


import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.tasks.Task;
import com.example.timemanager.ui.tasks.TaskActivity;

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


    public void setOnItemClickListener (OnTaskListener listener){
        onTaskListener = listener;
    }


    /**
     * interface to detect a click
     */
    public interface OnTaskListener{
        //used in the activity to send position of clicked item
        void onTaskClick(int position);
        void onDeleteClick(int position);
    }


    /**
     * static class ViewHolder for different views (elements) of a recycler view
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView taskName;
        public ImageView deleteImage;
        OnTaskListener onTaskListener;

        private ToggleButton toggleButton;
        private Chronometer chrono;

        long timeElapsed = 0;

        public ViewHolder(@NonNull View view, OnTaskListener onTaskListener) {
            super(view);
            taskName = (TextView) view.findViewById(R.id.taskName);
            deleteImage = itemView.findViewById(R.id.image_deleteTask);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onTaskListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onTaskListener.onTaskClick(position);
                        }
                    }
                }
            });
            this.onTaskListener = onTaskListener;

            deleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onTaskListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onTaskListener.onDeleteClick(position);
                        }
                    }
                }
            });

            toggleButton = (ToggleButton) view.findViewById(R.id.tbtnChronometerTask);
            chrono = (Chronometer) view.findViewById(R.id.chronometer);

            chrono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                @Override
                public void onChronometerTick(Chronometer chronometer) {
                    timeElapsed = SystemClock.elapsedRealtime() - chronometer.getBase();
                }
            });

            toggleButton.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked == true)
                    {
                        if(timeElapsed == 0){
                            chrono.setBase(SystemClock.elapsedRealtime());
                            chrono.start();
                        }

                        Toast.makeText(buttonView.getContext(), "ON State",
                                Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        if(timeElapsed != 0){
                            timeElapsed = 0;
                            chrono.stop();
                        }
                        Toast.makeText(buttonView.getContext(), "OFF State",
                                Toast.LENGTH_SHORT).show();
                    }
                }


            });

        }
        @Override
        public void onClick(View view) {
            onTaskListener.onTaskClick(getAdapterPosition());
            Toast.makeText(view.getContext(), "position : " + getLayoutPosition() + " text : " + this.taskName.getText(), Toast.LENGTH_SHORT).show();
            Toast.makeText(view.getContext(), "The Item Clicked is: "+getLayoutPosition(),Toast.LENGTH_SHORT).show();

        }
    }








    /**
     *
     * @param parent
     * @param viewType
     * @return
     * @throws NullPointerException
     */
    @Override
    public RecyclerViewAdapterTasks.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) throws NullPointerException {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_item_view_tasks, parent, false);
        ViewHolder viewHolder = new ViewHolder(v, onTaskListener);

        return viewHolder;
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterTasks.ViewHolder holder, int position){
        //holder.textView.setText(data.get(position).getClass().getName());
        Task currentItem = data.get(position);
        holder.taskName.setText(currentItem.getTaskName());
    }

    /**
     *
     * @return number of items in list
     */
    @Override
    public int getItemCount() {
        return this.data.size();
    }






}
