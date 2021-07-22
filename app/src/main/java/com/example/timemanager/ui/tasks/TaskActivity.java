package com.example.timemanager.ui.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.projects.Project;
import com.example.timemanager.ui.recycler.RecyclerViewAdapterTasks;

import java.util.ArrayList;
import java.util.List;

/**
 * opens activity_task, creates a RecyclerView and a list of tasks
 */
public class TaskActivity extends AppCompatActivity implements RecyclerViewAdapterTasks.OnTaskListener {

    private List<Task> taskList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapterTasks recyclerViewAdapterTasks;
    private Button btnAddT;
    private EditText etAddT;
    private Project project = new Project ("Time Manager", "App, die das Zeitmanagement vereinfacht.", 11.1, "grün");

    /**
     * opens activity_tasks, creates a list of tasks, builds a recycler view and sets button needed to add a new task
     * further information in AppCompatActivity
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        createTaskList();
        buildRecyclerView();
        setButtons();
    }


    /**
     * method setting up button to add a new task.
     * After writing the name of the task and clicking on the button, the task will be added.
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
                    taskList.add(new Task (getInput, true, project));
                }
            }
        });
    }


    /**
     * deletes Item from List on a specific position
     * @param position position of the item that needs to be deleted
     */
    private void deleteItem(int position) {
        taskList.remove(position);
        recyclerViewAdapterTasks.notifyItemRemoved(position);
    }

    /**
     * Method building recyclerview
     */
    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewTasks);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapterTasks = new RecyclerViewAdapterTasks(this, taskList, this);
        recyclerView.setAdapter(recyclerViewAdapterTasks);
        recyclerViewAdapterTasks.setOnItemClickListener((new RecyclerViewAdapterTasks.OnTaskListener() {

            @Override
            public void onDeleteClick(int position) {
                deleteItem(position);
            }
        }));
    }

    /**
     * method creating a list of tasks (containing a project)
     */
    private void createTaskList() {
        taskList = new ArrayList<>();

        taskList.add(new Task("Arbeit aufteilen", true, project));
        taskList.add(new Task("Gruppen bilden", false, project));
    }

    /**
     * delete task by clicking on the delete icon in a recycler view item
     * @param position position of the task that needs to be deleted
     */
    @Override
    public void onDeleteClick(int position) {
        deleteItem(position);
    }
}

