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


/**
 * class needed to create a recyclerview with different bookings and display them in activity_bookings
 */
public class BookingActivity extends AppCompatActivity{

    private List<Booking> bookingList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapterBookings recyclerViewAdapterBookings;

    /**
     * opens activity_bookings, creates a list of bookings and builds a recycler view
     * further information in AppCompatActivity
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        createBookingList();
        buildRecyclerView();
    }

    /**
     * method building recyclerview
     */
    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewBookings);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterBookings = new RecyclerViewAdapterBookings(this, bookingList);
        recyclerView.setAdapter(recyclerViewAdapterBookings);
    }

    /**
     * method creating a list with bookings
     */
    private void createBookingList() {
        int timeWorked1 = 1;
        int timeWorked2 = 2;
        bookingList = new ArrayList<>();
        bookingList.add(new Booking("Buchung 1", timeWorked1));
        bookingList.add(new Booking("Buchung 2", timeWorked2));
    }

}

