package com.example.timemanager.ui.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.projects.Project;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    private List<Project> data;
    public RecyclerViewAdapter (List<Project> data){
        this.data = data;
    }

    public RecyclerViewAdapter(Context context, List<Project> data){
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) throws NullPointerException {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position){
        //holder.textView.setText(data.get(position).getClass().getName());
        holder.projektName.setText(data.get(position).getProjName());
        holder.beschreibung.setText(data.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //private TextView textView;
        private TextView projektName;
        private TextView beschreibung;
        public ViewHolder(View view) {
            super(view);
            projektName = (TextView) view.findViewById(R.id.name_projekt);
            beschreibung = (TextView) view.findViewById(R.id.beschreibung_projekt);
           // this.textView = view.findViewById(R.id.textview);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "position : " + getLayoutPosition() + " text : " + this.projektName.getText(), Toast.LENGTH_SHORT).show();
            Toast.makeText(view.getContext(), "position : " + getLayoutPosition() + " text : " + this.beschreibung.getText(), Toast.LENGTH_SHORT).show();
        }
    }

}
