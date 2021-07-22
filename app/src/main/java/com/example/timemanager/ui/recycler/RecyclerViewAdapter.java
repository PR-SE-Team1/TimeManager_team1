package com.example.timemanager.ui.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.projects.Project;

import java.util.List;

/**
 * class used to create a recycler view of projects displayed on projectscreen
 * these projects open a new activity when clicked
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    private static List<Project> data;
    private OnProjectListener onProjectListener;

    /**
     * constructor for a recycler view adapter
     * @param context context of this adapter
     * @param data list of projects displayed in recyclerview
     * @param onProjectListener listener to open the specific project when clicked
     */
    public RecyclerViewAdapter(Context context, List<Project> data, OnProjectListener onProjectListener){
        this.context = context;
        this.data = data;
        this.onProjectListener = onProjectListener;
    }

    /**
     * inflates the recycler_item_view (single cardview-items of a recyclerview) and represents an item
     * further information in RecyclerView.Adapter
     * @param parent
     * @param viewType
     * @return viewHolder with view and listener
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) throws NullPointerException, IllegalArgumentException {
        context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v, onProjectListener);
        return viewHolder;
    }

    /**
     * displays the data on a specific position
     * further information in RecyclerView.Adapter
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position){
        holder.projectName.setText(data.get(position).getProjName());
        holder.description.setText(data.get(position).getDescription());
    }

    /**
     * gets the number of items in the recycler view
     * @return number of items (int)
     */
    @Override
    public int getItemCount() {
        return this.data.size();
    }


    /**
     * class for different views (elements) of a recycler view
     */
    public class ViewHolder extends RecyclerView.ViewHolder  {
        private TextView projectName, description;
        OnProjectListener onProjectListener;
        public ViewHolder(@NonNull View view, OnProjectListener onProjectListener) {
            super(view);
            projectName =  view.findViewById(R.id.projName);
            description = view.findViewById(R.id.projDescr);

            view.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    onProjectListener.onProjectClick(data.get(getAdapterPosition()));
                }
            });
            this.onProjectListener = onProjectListener;
        }
    }

    /**
     * interface created to detect a click
     * onProjectClick is used in the activity to send clicked project
     */
    public interface OnProjectListener{
        void onProjectClick(Project project);
    }


}
