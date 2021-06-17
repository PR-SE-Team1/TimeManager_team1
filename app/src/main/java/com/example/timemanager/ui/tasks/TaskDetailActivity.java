package com.example.timemanager.ui.tasks;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.projects.Project;
import com.example.timemanager.ui.recycler.RecyclerViewAdapterTasks;

import java.util.ArrayList;
import java.util.List;

public class TaskDetailActivity extends AppCompatActivity {

    public List<String> taskList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //opening activity
        setContentView(R.layout.activity_edit_tasks);

        //spinner TASK
        taskList = new ArrayList<>();
        taskList.add(new Task("Aufgabe1", new Project( "Projekt11", "kurzbeschreibung 11", 11.1, "blue"), true).getTaskName());
        taskList.add(new Task("Aufgabe2", new Project( "Projekt12", "kurzbeschreibung 12", 11.1, "blue"), false).getTaskName());

        Spinner spinnerT;
        spinnerT = findViewById(R.id.spinnerEditTask);
        ArrayAdapter arrayAdapterT = new ArrayAdapter(this,android.R.layout.simple_spinner_item,taskList);
        arrayAdapterT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerT.setAdapter(arrayAdapterT);



    }
}
