package com.example.timemanager.ui.projects;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Spinner;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timemanager.R;
import com.example.timemanager.ui.tasks.Task;
import com.example.timemanager.ui.tasks.TaskActivity;

import java.util.ArrayList;
import java.util.List;


public class ProjectDetailActivity extends AppCompatActivity {

    public List<String> projectList = new ArrayList<>();
    public List<String> taskList = new ArrayList<>();
    public List<String> colorList = new ArrayList<>();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //opening activity
        setContentView(R.layout.activity_edit_projects);

//        // spinner edit PROJECT
//        projectList.add(new Project ("Projekt1", "kurzbeschreibung 1", 11.1, "blue").getProjName());
//        projectList.add(new Project ( "Projekt2", "kurzbeschreibung 2", 12.1, "blue").getProjName());
//        projectList.add(new Project ( "Projekt3", "kurzbeschreibung 3", 13.1, "blue").getProjName());
//        Spinner spinnerP;
//        spinnerP = findViewById(R.id.spinnerEditChangeProj);
//        ArrayAdapter arrayAdapterP = new ArrayAdapter(this,android.R.layout.simple_spinner_item,projectList);
//        arrayAdapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerP.setAdapter(arrayAdapterP);


        //spinner edit TASK
        taskList.add(new Task("Aufgabe1", new Project( "Projekt11", "kurzbeschreibung 11", 11.1, "blue"), true).getTaskName());
        taskList.add(new Task("Aufgabe2", new Project( "Projekt12", "kurzbeschreibung 12", 11.1, "blue"), false).getTaskName());
        Spinner spinnerT;
        spinnerT = findViewById(R.id.spinnerEditDefTask);
        ArrayAdapter arrayAdapterT = new ArrayAdapter(this,android.R.layout.simple_spinner_item,taskList);
        arrayAdapterT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerT.setAdapter(arrayAdapterT);


        //spinner edit COLOR
        colorList.add("BLAU");
        colorList.add("ROT");
        colorList.add("GRÜN");
        Spinner spinnerC;
        spinnerC = findViewById(R.id.spinnerEditColor);
        ArrayAdapter arrayAdapterC = new ArrayAdapter(this,android.R.layout.simple_spinner_item,colorList);
        arrayAdapterC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerC.setAdapter(arrayAdapterC);






    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
    }

}