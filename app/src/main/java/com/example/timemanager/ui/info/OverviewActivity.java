package com.example.timemanager.ui.info;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timemanager.R;

/**
 * class used to open activity_info_overview
 * the calendar is displayed and further functionalities can be included here
 */
public class OverviewActivity extends AppCompatActivity {

    /**
     * opens activity_info_overview
     *further information in AppCompatActivity
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_overview);
    }

}
