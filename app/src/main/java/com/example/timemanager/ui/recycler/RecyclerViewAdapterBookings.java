package com.example.timemanager.ui.recycler;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.bookings.Booking;

import java.util.List;

/**
 * class used to create a recycler view of tasks displayed on taskscreen
 * these tasks open a new activity when clicked
 */
public class RecyclerViewAdapterBookings extends RecyclerView.Adapter<RecyclerViewAdapterBookings.ViewHolder> {

    Context context;
    private List<Booking> data;


    /**
     * constructor for a recycler view adapter
     * @param context
     * @param data
     * @param
     */
    public RecyclerViewAdapterBookings(Context context, List<Booking> data){
        this.context = context;
        this.data = data;
    }


    /**
     * static class ViewHolder for different views (elements) of a recycler view
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView bookingName;
        public ImageView deleteImage;

        public ViewHolder(@NonNull View view) {
            super(view);
            bookingName = (TextView) view.findViewById(R.id.bookingName);
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
    public RecyclerViewAdapterBookings.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) throws NullPointerException {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_item_view_bookings, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }//IllegalArgumentException?

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterBookings.ViewHolder holder, int position){
        //holder.textView.setText(data.get(position).getClass().getName());
        Booking currentItem = data.get(position);
        holder.bookingName.setText(currentItem.getBookingName());
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
