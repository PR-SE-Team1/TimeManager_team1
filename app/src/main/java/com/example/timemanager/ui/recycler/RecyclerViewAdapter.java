package com.example.timemanager.ui.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.projects.Project;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List <Project> projectList;
    private static LayoutInflater mInflater;
    private static ItemClickListener mClickListener;

    /**
     * initialize the dataset of the Adapter
     * @param dataSet containing data to be used by RecyclerView
     */
    public RecyclerViewAdapter(Context context, List<Project> dataSet){
        this.mInflater = LayoutInflater.from(context);
        this.projectList = dataSet;
    }

    /**
     * create new views (invoked by layout manager)
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create new view, which defines the UI of the list item
        View view = mInflater.inflate(R.layout.text_row_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * replace the contents of a view (invoked by layout manager)
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Project project = projectList.get(position);
        holder.textView.setText((CharSequence) project);
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView textView;
        public ViewHolder(View v) {
            super(v);
            textView = itemView.findViewById(R.id.projectName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }



    // convenience method for getting data at click position
    Project getItem(int id) {
        return projectList.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
