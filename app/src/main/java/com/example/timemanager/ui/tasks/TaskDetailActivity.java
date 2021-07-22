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

/**
 * opens activity_edit_task, shows Information inside of a spinner
 */
public class TaskDetailActivity extends AppCompatActivity {

    public List<String> taskList = new ArrayList<>();
    public Project project = new Project ("Time Manager", "App, die das Zeitmanagement vereinfacht.", 11.1, "grün");

    /**
     * opens activity_edit_tasks and contains the implementation to display information of a task.
     * The name of the task is displayed in a spinner
     * further information in AppCompatActivity
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tasks);

        taskList = new ArrayList<>();


        taskList.add(new Task("Arbeit aufteilen", true, project).getTaskName());
        taskList.add(new Task("Gruppen bilden", false, project).getTaskName());

        Spinner spinnerT;
        spinnerT = findViewById(R.id.spinnerEditTask);
        ArrayAdapter arrayAdapterT = new ArrayAdapter(this,android.R.layout.simple_spinner_item,taskList);
        arrayAdapterT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerT.setAdapter(arrayAdapterT);


    }
}
