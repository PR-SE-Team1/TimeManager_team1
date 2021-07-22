package com.example.timemanager.ui.info;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.timemanager.R;
import com.example.timemanager.ui.bookings.BookingActivity;

/**
 * class needed to open fragment_info and create buttons used to access WorkingHoursDaily, Overview and BookingList
 */
public class InfoFragment extends Fragment {

    /**
     * opens fragment_info and contains functionality to open WorkingHoursDailyActivity, OverviewActivity and BookingActivity by clicking on a button
     * further information in extended Fragment
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        Button btnWorkingHours = (Button) view.findViewById(R.id.btnInfoWorkingHours);
        btnWorkingHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WorkingHoursDailyActivity.class);
                startActivity(intent);
            }
        });

        Button btnOverview = (Button) view.findViewById(R.id.btnInfoOverview);
        btnOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OverviewActivity.class);
                startActivity(intent);
            }
        });

        Button btnBookings = (Button) view.findViewById(R.id.btnInfoBookingList);
        btnBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookingActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}