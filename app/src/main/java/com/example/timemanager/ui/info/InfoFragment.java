package com.example.timemanager.ui.info;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.timemanager.MainActivity;
import com.example.timemanager.R;


public class InfoFragment extends Fragment {

    private InfoViewModel infoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        infoViewModel =
                new ViewModelProvider(this).get(InfoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_info, container, false);
        final TextView textView = root.findViewById(R.id.infoText);
        infoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    public void openOverview(View v){
//        Intent intent = new Intent(this, OverviewActivity.class);
        Intent intent = new Intent(getActivity(), OverviewActivity.class);
        startActivity(intent);
    }

    public void openWorkinghours(View view){
//        Intent intent = new Intent(this, WorkingHoursWeeklyActivity.class);
        Intent intent = new Intent(getActivity(), OverviewActivity.class);
        startActivity(intent);
    }
}