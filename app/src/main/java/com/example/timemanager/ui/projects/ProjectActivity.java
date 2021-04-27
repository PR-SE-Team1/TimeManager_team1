package com.example.timemanager.ui.projects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.timemanager.R;

public class ProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_projects);

        //fetching data from a parcelable object passed from MainActivity
        Project project = getIntent().getParcelableExtra("project");

        if (project!= null) {
            //setTextView
        }
    }

    public void launchProject(View v){

        Intent i = new Intent(this, ProjectActivity.class);
        startActivity(i);
    }
}