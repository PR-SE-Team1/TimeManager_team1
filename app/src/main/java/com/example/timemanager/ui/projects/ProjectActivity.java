package com.example.timemanager.ui.projects;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timemanager.R;

import java.util.ArrayList;
import java.util.List;

public class ProjectActivity extends AppCompatActivity {

    public List<String> projectList = new ArrayList<>();
    public List<String> taskList = new ArrayList<>();
    public List<String> colorList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //opening activity
        setContentView(R.layout.activity_edit_projects);

        // spinner edit PROJECT
        projectList.add(new Project ("Projekt1", "kurzbeschreibung 1", 11.1, "blue").getProjName());
        projectList.add(new Project ("Projekt2", "kurzbeschreibung 2", 12.1, "blue").getProjName());
        projectList.add(new Project ("Projekt3", "kurzbeschreibung 3", 13.1, "blue").getProjName());
        Spinner spinnerP;
        spinnerP = findViewById(R.id.spinnerEditChangeProj);
        ArrayAdapter arrayAdapterP = new ArrayAdapter(this,android.R.layout.simple_spinner_item,projectList);
        arrayAdapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerP.setAdapter(arrayAdapterP);


        //spinner edit TASK
        taskList.add(new Project ("Aufgabe1", "kurzbeschreibung 1", 11.1, "blue").getProjName());
        taskList.add(new Project ("Augabe2", "kurzbeschreibung 2", 12.1, "blue").getProjName());
        taskList.add(new Project ("Aufgabe3", "kurzbeschreibung 3", 13.1, "blue").getProjName());
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
}
