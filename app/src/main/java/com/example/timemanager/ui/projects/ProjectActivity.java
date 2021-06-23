package com.example.timemanager.ui.projects;

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
import com.example.timemanager.ui.recycler.RecyclerViewAdapter;
import com.example.timemanager.ui.recycler.RecyclerViewAdapterTasks;
import com.example.timemanager.ui.tasks.Task;

import java.util.ArrayList;
import java.util.List;


public class ProjectActivity extends AppCompatActivity implements RecyclerViewAdapter.OnProjectListener {

    List<Project> projectList;

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    private Button btnAddP;
    private EditText etAddP;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        setContentView(R.layout.activity_projects);

        createProjectList();
        buildRecyclerView();
        setButtons();
    }

    /**
     * method setting up buttons
     */
    private void setButtons() {
        btnAddP = findViewById(R.id.btnAddNewProject);
        etAddP = findViewById(R.id.etAddNewProject);

        btnAddP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = etAddP.getText().toString();

                if (projectList.contains(getInput)){
                    Toast.makeText(getBaseContext(), "Projekt existiert bereits", Toast.LENGTH_LONG).show();
                } else if (getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(), "Kein Name eingegeben", Toast.LENGTH_LONG).show();
                }else {
                    projectList.add(new Project(getInput));
                }
            }
        });
    }



    /**
     * add items to list
     * @param position
     */
    private void insertItem(int position) {
        projectList.add(position, new Project("Projekt11", "kurzbeschreibung 11", 11.1, "blue"));
        recyclerViewAdapter.notifyItemInserted(position);
    }


    /**
     * deletes Item from List
     * @param position
     */
    private void deleteItem(int position) {
        projectList.remove(position);
        recyclerViewAdapter.notifyItemRemoved(position);
    }

    /**
     * Method building recyclerview
     */
    private void buildRecyclerView() {
        // set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerViewProjects);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(this, projectList, this);
        //recyclerViewAdapterTasks.setClickListener(this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }


    /**
     * method creating project list
     *
     */
    private void createProjectList() {
        projectList = new ArrayList<>();
        projectList.add(new Project ("Projekt1", "kurzbeschreibung 1", 11.1, "blue"));
        projectList.add(new Project ("Projekt2", "kurzbeschreibung 2", 12.1, "blue"));
        projectList.add(new Project ( "Projekt3", "kurzbeschreibung 3", 13.1, "blue"));
        projectList.add(new Project ( "Projekt4", "kurzbeschreibung 4", 14.1, "blue"));
        projectList.add(new Project ("Projekt5", "kurzbeschreibung 5", 15.1, "blue"));

    }


//    //get to another activity by clicking on the task
//    @Override
//    public void onProjectClick(int position) {
//        Intent intent = new Intent(this, ProjectDetailActivity.class);
//        startActivity(intent);
//    }


    @Override
    public void onProjectClick(Project project) {
        startActivity(new Intent(ProjectActivity.this, ProjectDetailActivity.class).putExtra("data", project));

    }
}
