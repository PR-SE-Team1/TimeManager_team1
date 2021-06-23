package com.example.timemanager.ui.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.projects.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * class used to create a recycler view of projects displayed on homescreen
 * these projects open a new activity when clicked
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    private List<Project> data;
    private LayoutInflater inflater;
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
        inflater = LayoutInflater.from(context);
        this.onProjectListener = onProjectListener;

    }


    /**
     *
     * @param parent
     * @param viewType
     * @return
     * @throws NullPointerException
     */
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) throws NullPointerException {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v, onProjectListener);

        return viewHolder;
    }

    /**
     * passing values
     * @param holder
     * @param position to know the item
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position){
        Project currentItem = data.get(position);
        //holder.textView.setText(data.get(position).getClass().getName());
        holder.projektName.setText(currentItem.getProjName());
        holder.beschreibung.setText(currentItem.getDescription());
    }

    /**
     *
     * @return number of items in list
     */
    @Override
    public int getItemCount() {
        return this.data.size();
    }

    /**
     * static class ViewHolder for different views (elements) of a recycler view
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView projektName, beschreibung;
        public ImageView deleteImage;
        OnProjectListener onProjectListener;

        public ViewHolder(@NonNull View view, OnProjectListener onProjectListener) {
            super(view);
            projektName = (TextView) view.findViewById(R.id.projName);
            beschreibung = (TextView) view.findViewById(R.id.projDescr);
            deleteImage = itemView.findViewById(R.id.image_delete);
            view.setOnClickListener(this);
            this.onProjectListener = onProjectListener;

            deleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onProjectListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onProjectListener.onDeleteClick(position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            onProjectListener.onProjectClick(getAdapterPosition());
            //TextView text = (TextView) view.findViewById(R.id.projName);
            //String name = text.getText().toString();
            Toast.makeText(view.getContext(), "position : " + getLayoutPosition() + " text : " + this.projektName.getText(), Toast.LENGTH_SHORT).show();
            Toast.makeText(view.getContext(), "position : " + getLayoutPosition() + " text : " + this.beschreibung.getText(), Toast.LENGTH_SHORT).show();
            Toast.makeText(view.getContext(), "The Item Clicked is: "+getLayoutPosition(),Toast.LENGTH_SHORT).show();



        }


    }

    public void setOnItemClickListener (RecyclerViewAdapter.OnProjectListener listener){
        onProjectListener = listener;
    }



    /**
     * interface to detect a click
     */
    public interface OnProjectListener{
        //used in the activity to send position of clicked item
        void onProjectClick(int position);

        void onDeleteClick(int position);
    }

}
