package com.example.timemanager.ui.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.projects.Project;

import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

/**
 * class used to create a recycler view of projects displayed on homescreen
 * these projects open a new activity when clicked
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    private static List<Project> data;
    private OnProjectListener onProjectListener;


    /**
     * constructor for a recycler view adapter
     * @param context
     * @param data
     * @param onProjectListener
     */
    public RecyclerViewAdapter(Context context, List<Project> data, OnProjectListener onProjectListener){
        this.context = context;
        this.data = data;
        this.onProjectListener = onProjectListener;

    }



    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) throws NullPointerException {
        context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v, onProjectListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position){
        holder.projektName.setText(data.get(position).getProjName());
        holder.beschreibung.setText(data.get(position).getDescription());

    }


    @Override
    public int getItemCount() {
        return this.data.size();
    }


    /**
     * static class ViewHolder for different views (elements) of a recycler view
     */
    public class ViewHolder extends RecyclerView.ViewHolder  {
        private TextView projektName, beschreibung;
        OnProjectListener onProjectListener;

        public ViewHolder(@NonNull View view, OnProjectListener onProjectListener) {
            super(view);
            projektName =  view.findViewById(R.id.projName);
            beschreibung = view.findViewById(R.id.projDescr);

            view.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    onProjectListener.onProjectClick(getAdapterPosition());
                }
            });
            this.onProjectListener = onProjectListener;

        }
//        @Override
//        public void onClick(View view) {
//            onProjectListener.onProjectClick(getAdapterPosition());
//            int pos = getAdapterPosition();
//
//            Toast.makeText(view.getContext(), "position : " + getLayoutPosition() + " text : " + this.projektName.getText(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(view.getContext(), "position : " + getLayoutPosition() + " text : " + this.beschreibung.getText(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(view.getContext(), "The Item Clicked is: "+getLayoutPosition(),Toast.LENGTH_SHORT).show();
//
//        }
    }

    /**
     * interface to detect a click
     */
    public interface OnProjectListener{
        //used in the activity to send position of clicked item
        void onProjectClick(int position);
    }

    public void setOnProjectListener(OnProjectListener listener) {
        onProjectListener = listener;
    }


}
