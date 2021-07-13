package com.example.timemanager.ui.bookings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.projects.Project;
import com.example.timemanager.ui.recycler.RecyclerViewAdapterBookings;
import com.example.timemanager.ui.recycler.RecyclerViewAdapterTasks;

import java.util.ArrayList;
import java.util.List;


public class BookingActivity extends AppCompatActivity {

    private List<Booking> bookingList;

    private RecyclerView recyclerView;
    private RecyclerViewAdapterBookings recyclerViewAdapterBookings;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        createBookingList();
        buildRecyclerView();
        //setButtons();



    }


//    /**
//     * method setting up buttons
//     */
//    private void setButtons() {
//        btnAddT = findViewById(R.id.btnAddNewTask);
//        etAddT = findViewById(R.id.etAddNewTask);
//
//        btnAddT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String getInput = etAddT.getText().toString();
//
//                if (taskList.contains(getInput)){
//                    Toast.makeText(getBaseContext(), "Aufgabe existiert bereits", Toast.LENGTH_LONG).show();
//                } else if (getInput == null || getInput.trim().equals("")){
//                    Toast.makeText(getBaseContext(), "Kein Name eingegeben", Toast.LENGTH_LONG).show();
//                }else {
//                    taskList.add(new Booking(getInput));
//                }
//            }
//        });
//    }

    /**
     * add items to list
     * @param position
     */
    private void insertItem(int position) {
        bookingList.add(position, new Booking("Buchung3", 3));
        recyclerViewAdapterBookings.notifyItemInserted(position);
    }

    /**
     * deletes Item from List
     * @param position
     */
    private void deleteItem(int position) {
        bookingList.remove(position);
        recyclerViewAdapterBookings.notifyItemRemoved(position);
    }

    /**
     * Method building recyclerview
     */
    private void buildRecyclerView() {
        // set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerViewTasks);
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
        bookingList = new ArrayList<>();
        bookingList.add(new Booking("Buchung 1", 1));
        bookingList.add(new Booking("Buching 2", 2));
    }



}

