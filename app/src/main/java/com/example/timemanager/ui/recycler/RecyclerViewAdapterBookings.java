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
    private RecyclerViewAdapterBookings.OnBookingListener onBookingListener;



    /**
     * constructor for a recycler view adapter
     * @param context
     * @param data
     * @param
     */
    public RecyclerViewAdapterBookings(Context context, List<Booking> data, OnBookingListener onBookingListener){
        this.context = context;
        this.data = data;
        this.onBookingListener = onBookingListener;
    }

    public void setOnItemClickListener (RecyclerViewAdapterBookings.OnBookingListener listener){
        onBookingListener = listener;
    }

    /**
     * interface to detect a click
     */
    public interface OnBookingListener{
        //used in the activity to send position of clicked item
        void onBookingClick(int position);
        void onDeleteClick(int position);
    }

    /**
     * static class ViewHolder for different views (elements) of a recycler view
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView bookingName;
        public ImageView deleteImage;


        public ViewHolder(@NonNull View view, OnBookingListener onBookingListener) {
            super(view);
            bookingName = (TextView) view.findViewById(R.id.bookingName);
            deleteImage = itemView.findViewById(R.id.image_deleteTask);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onBookingListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onBookingListener.onBookingClick(position);
                        }
                    }
                }
            });



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
        ViewHolder viewHolder = new ViewHolder(v, onBookingListener);

        return viewHolder;
    }

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
