package com.example.timemanager.ui.tasks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapterTasks;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button btnAddT;
    private EditText etAddT;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        createActivityList();
        buildRecyclerView();

        btnAddT = findViewById(R.id.btnAddNewTask);
        etAddT = findViewById(R.id.etAddNewTask);

        btnAddT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = etAddT.getText().toString();

                if (taskList.contains(getInput)){
                    Toast.makeText(getBaseContext(), "Aufgabe existiert bereits", Toast.LENGTH_LONG).show();
                } else if (getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(), "Kein Name eingegeben", Toast.LENGTH_LONG).show();
                }else {
                    taskList.add(new Task (getInput));
                    
                }
            }
        });



    }

    /**
     * add items to list
     * @param position
     */
    private void insertItem(int position) {
        taskList.add(position, new Task("Aufgabe3", new Project("Projekt11", "kurzbeschreibung 11", 11.1, "blue"), true));
        recyclerViewAdapterTasks.notifyItemInserted(position);
    }

    private void buildRecyclerView() {
        // set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerViewTasks);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterTasks = new RecyclerViewAdapterTasks(this, taskList, this);
        //recyclerViewAdapterTasks.setClickListener(this);
        recyclerView.setAdapter(recyclerViewAdapterTasks);
    }

    private void createActivityList() {
        taskList = new ArrayList<>();
        taskList.add(new Task("Aufgabe1", new Project( "Projekt11", "kurzbeschreibung 11", 11.1, "blue"), true));
        taskList.add(new Task("Aufgabe2", new Project("Projekt12", "kurzbeschreibung 12", 11.1, "blue"), false));
    }


    //get to another activity by clicking on the task
    @Override
    public void onTaskClick(int position) {
        Intent intent = new Intent(this, TaskDetailActivity.class);
        startActivity(intent);

    }
}

