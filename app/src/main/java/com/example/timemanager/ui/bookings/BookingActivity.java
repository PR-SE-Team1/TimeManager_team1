package com.example.timemanager.ui.bookings;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.recycler.RecyclerViewAdapterBookings;

import java.util.ArrayList;
import java.util.List;

//implements RecyclerViewAdapterTasks.OnTaskListener

public class BookingActivity extends AppCompatActivity{

    private List<Booking> bookingList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapterBookings recyclerViewAdapterBookings;
    //sonarqube sagt die Felder müssen inirialisiert werden


    /**
     * constructor for code quality
     */
    public BookingActivity(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        createBookingList();
        buildRecyclerView();
    }

    /**
     * add items to list
     * @param position
     */

    /**private void insertItem(int position) {
        bookingList.add(position, new Booking("Buchung3", 3));
        recyclerViewAdapterBookings.notifyItemInserted(position);
    }*/
//soll laut sonarqube gelöscht werden, weil es nicht gebraucht wird, und die nummer 3 soll zu einer konstante gemacht werden


    /**
     * Method building recyclerview
     */
    private void buildRecyclerView() {
        // set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerViewBookings);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterBookings = new RecyclerViewAdapterBookings(this, bookingList);
        //recyclerViewAdapterTasks.setClickListener(this);
        recyclerView.setAdapter(recyclerViewAdapterBookings);
    }

    /**
     * method creating task list
     *
     */
    private void createBookingList() {
        int timeWorked1 = 1;//mussten laut sonarqube geändert werden
        int timeWorked2 = 2;
        bookingList = new ArrayList<>();
        bookingList.add(new Booking("Buchung 1", timeWorked1));
        bookingList.add(new Booking("Buching 2", timeWorked2));
    }

}

