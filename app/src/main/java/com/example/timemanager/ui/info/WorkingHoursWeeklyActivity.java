package com.example.timemanager.ui.info;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timemanager.R;

public class WorkingHoursWeeklyActivity extends AppCompatActivity {
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //opening activity
        setContentView(R.layout.activity_info_workinghours_weekly);
    }

    public void openWorkingHoursDaily (View v){
        Intent intent = new Intent(this, WorkingHoursDailyActivity.class);
        startActivity(intent);
    }
}