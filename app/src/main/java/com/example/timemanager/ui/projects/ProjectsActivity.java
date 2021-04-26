package com.example.timemanager.ui.projects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.timemanager.R;

public class ProjectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_projects);
    }

    public void launchProject(View v){

        Intent i = new Intent(this, ProjectsActivity.class);
        startActivity(i);
    }
}