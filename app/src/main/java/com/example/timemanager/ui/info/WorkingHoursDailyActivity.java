package com.example.timemanager.ui.info;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timemanager.R;
import com.example.timemanager.ui.tasks.TaskActivity;

public class WorkingHoursDailyActivity extends AppCompatActivity {
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //opening activity
        setContentView(R.layout.activity_info_workinghours_daily);
    }

    public void openWorkingHoursWeekly (View v){
        Intent intent = new Intent(this, WorkingHoursWeeklyActivity.class);
        startActivity(intent);
    }
}
