package com.example.timemanager.ui.info;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timemanager.R;
import com.example.timemanager.ui.tasks.TaskActivity;

/**
 * class used to open activity_info_workinghours_daily
 */
public class WorkingHoursDailyActivity extends AppCompatActivity {

    /**
     *opens activity_info_workinghours_daily
     *further information in AppCompatActivity
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_workinghours_daily);
    }

    /**
     * navigating from WorkingHoursDailyActivity to WorkingHoursWeeklyActivity
     * a new activity is opened
     * @param v view of the current activity
     */
    public void openWorkingHoursWeekly (View v){
        Intent intent = new Intent(this, WorkingHoursWeeklyActivity.class);
        startActivity(intent);
    }
}
