package com.example.timemanager.ui.tasks;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timemanager.R;
import com.example.timemanager.ui.projects.Project;

import java.util.ArrayList;
import java.util.List;

public class TaskDetailActivity extends AppCompatActivity {

    public List<String> taskList = new ArrayList<>();

    public Project project = new Project("Project1", "Beschreibung", 28, "red");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //opening activity
        setContentView(R.layout.activity_edit_tasks);

        //spinner TASK
        taskList = new ArrayList<>();
        taskList.add(new Task("Aufgabe1", true, project).getTaskName());
        taskList.add(new Task("Aufgabe2", false, project).getTaskName());

        Spinner spinnerT;
        spinnerT = findViewById(R.id.spinnerEditTask);
        ArrayAdapter arrayAdapterT = new ArrayAdapter(this,android.R.layout.simple_spinner_item,taskList);
        arrayAdapterT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerT.setAdapter(arrayAdapterT);



    }
}
