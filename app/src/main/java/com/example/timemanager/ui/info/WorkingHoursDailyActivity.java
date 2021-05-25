package com.example.timemanager.ui.info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.timemanager.R;

public class WorkingHoursDailyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_hours_daily);
    }

    public void openWorkinghours(View view){
        Intent intent = new Intent(this, WorkingHoursWeeklyActivity.class);
        startActivity(intent);
    }
}