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


public class InfoFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        Button btnWorkingHours = (Button) root.findViewById(R.id.btnInfoWorkingHours);
        btnWorkingHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WorkingHoursDailyActivity.class);
                startActivity(intent);
            }
        });
        Button btnOverview = (Button) root.findViewById(R.id.btnInfoOverview);
        btnOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OverviewActivity.class);
                startActivity(intent);
            }
        });
        Button btnBookings = (Button) root.findViewById(R.id.btnInfoBookingList);
        btnBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookingActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}