package com.example.timemanager.ui.projects;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timemanager.R;
import com.example.timemanager.ui.tasks.Task;
import com.example.timemanager.ui.tasks.TaskActivity;

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
        projectList.add(new Project (1, "Time Manager", "Verwaltung von Projekten und dazugehörigen Aufgaben in einem Time Manager", 450, "blue").getProjName());
        projectList.add(new Project (2, "Bookend", "Erstellung einer App, in der gelesene Bücher organisiert werden können", 12.1, "blue").getProjName());
        projectList.add(new Project (3, "Calculator", "Taschenrechner-App mit der Berechnungen durchgeführt werden können", 13.1, "blue").getProjName());
        Spinner spinnerP;
        spinnerP = findViewById(R.id.spinnerEditChangeProj);
        ArrayAdapter arrayAdapterP = new ArrayAdapter(this,android.R.layout.simple_spinner_item,projectList);
        arrayAdapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerP.setAdapter(arrayAdapterP);


        //spinner edit TASK
        taskList.add(new Task("PROJ01", new Project(11, "Time Manager", "kurzbeschreibung 11", 11.1, "blue"), true).getTaskName());
        taskList.add(new Task("PROJ02", new Project(12, "Time Manager", "kurzbeschreibung 12", 11.1, "blue"), false).getTaskName());
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

    public void openTaskActivity(View view) {
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
    }

}
