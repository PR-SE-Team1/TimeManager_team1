package com.example.timemanager.ui.tasks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.home.HomeViewModel;
import com.example.timemanager.ui.projects.Project;
import com.example.timemanager.ui.projects.ProjectNew;
import com.example.timemanager.ui.recycler.RecyclerViewAdapter;
import com.example.timemanager.ui.recycler.RecyclerViewAdapterTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


public class TaskActivity extends AppCompatActivity implements RecyclerViewAdapterTasks.OnTaskListener {

    private List<Task> taskList;
    RecyclerViewAdapterTasks recyclerViewAdapterTasks;
    RecyclerViewAdapterTasks.OnTaskListener onTaskListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        taskList = new ArrayList<>();
        taskList.add(new Task("Aufgabe1", new Project(11, "Projekt11", "kurzbeschreibung 11", 11.1, "blue"), true));
        taskList.add(new Task("Aufgabe2", new Project(12, "Projekt12", "kurzbeschreibung 12", 11.1, "blue"), false));


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterTasks = new RecyclerViewAdapterTasks(this, taskList, onTaskListener);
        recyclerViewAdapterTasks.setClickListener(this);
        recyclerView.setAdapter(recyclerViewAdapterTasks);

    }


    //get to another activity by clicking on the task
    @Override
    public void onTaskClick(int position) {

    }
}

