package com.example.timemanager.ui.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.projects.Project;
import com.example.timemanager.ui.recycler.RecyclerViewAdapterTasks;

import java.util.ArrayList;
import java.util.List;


public class TaskActivity extends AppCompatActivity implements RecyclerViewAdapterTasks.OnTaskListener {

    private List<Task> taskList;

    private RecyclerView recyclerView;
    private RecyclerViewAdapterTasks recyclerViewAdapterTasks;

    private Button btnAddT;
    private EditText etAddT;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        createTaskList();
        buildRecyclerView();
        setButtons();



    }


    /**
     * method setting up buttons
     */
    private void setButtons() {
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

    /**
     * deletes Item from List
     * @param position
     */
    private void deleteItem(int position) {
        taskList.remove(position);
        recyclerViewAdapterTasks.notifyItemRemoved(position);
    }

    /**
     * Method building recyclerview
     */
    private void buildRecyclerView() {
        // set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerViewTasks);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterTasks = new RecyclerViewAdapterTasks(this, taskList, this);
        //recyclerViewAdapterTasks.setClickListener(this);
        recyclerView.setAdapter(recyclerViewAdapterTasks);

        recyclerViewAdapterTasks.setOnItemClickListener((new RecyclerViewAdapterTasks.OnTaskListener() {
            @Override
            public void onTaskClick(int position) {
                onTaskClick(position);
            }

            @Override
            public void onDeleteClick(int position) {
                deleteItem(position);
            }
        }));
    }

    /**
     * method creating task list
     *
     */
    private void createTaskList() {
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

    @Override
    public void onDeleteClick(int position) {
        deleteItem(position);

    }
}

