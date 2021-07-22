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
 * class used to create a recycler view of tasks displayed on bookingscreen
 * these bookings open a new activity when clicked
 */
public class RecyclerViewAdapterBookings extends RecyclerView.Adapter<RecyclerViewAdapterBookings.ViewHolder> {

    Context context;
    private List<Booking> data;

    /**
     * constructor for a recycler view adapter
     * @param context context of this adapter
     * @param data list of bookings displayed in recyclerview
     */
    public RecyclerViewAdapterBookings(Context context, List<Booking> data){
        this.context = context;
        this.data = data;
    }


    /**
     * class for different views (elements) of a recycler view
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView bookingName;

        public ViewHolder(@NonNull View view) {
            super(view);
            bookingName = (TextView) view.findViewById(R.id.bookingName);
        }
    }

    /**
     * inflates the recycler_item_view (single cardview-items of a recyclerview) and represents an item
     * further information in RecyclerView.Adapter
     * @param parent
     * @param viewType
     * @return viewHolder with view
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    @Override
    public RecyclerViewAdapterBookings.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) throws NullPointerException, IllegalArgumentException{
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_item_view_bookings, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    /**
     * displays the data on a specific position
     * further information in RecyclerView.Adapter
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterBookings.ViewHolder holder, int position){
        Booking currentItem = data.get(position);
        holder.bookingName.setText(currentItem.getBookingName());
    }

    /**
     * gets the number of items in the recycler view
     * @return number of items (int)
     */
    @Override
    public int getItemCount() {
        return this.data.size();
    }

}
