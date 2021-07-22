package com.example.timemanager.ui.info;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timemanager.R;

/**
 * class used to open activity_info_workinghours_weekly
 */
public class WorkingHoursWeeklyActivity extends AppCompatActivity {

    /**
     *opens activity_info_workinghours_weekly
     *further information in AppCompatActivity
     * @param savedInstanceState
     */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_workinghours_weekly);
    }

    /**
     * navigating from WorkingHoursWeeklyActivity to WorkingHoursDailyActivity
     * a new activity is opened
     * @param v view of the current activity
     */
    public void openWorkingHoursDaily (View v){
        Intent intent = new Intent(this, WorkingHoursDailyActivity.class);
        startActivity(intent);
    }
}