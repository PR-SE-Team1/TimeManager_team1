package com.example.timemanager.ui.info;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.timemanager.R;


public class InfoFragment extends Fragment {

    private InfoViewModel infoViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        infoViewModel =
                new ViewModelProvider(this).get(InfoViewModel.class);
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

        Button btnBookingList = (Button) root.findViewById(R.id.btnInfoBookingList);
        btnBookingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BookingListActivity.class);
                startActivity(intent);
            }
        });


        return root;
    }




}