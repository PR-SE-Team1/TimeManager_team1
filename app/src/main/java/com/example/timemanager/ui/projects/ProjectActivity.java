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

import java.util.ArrayList;
import java.util.List;

/**
 * class needed to create a recyclerview with different projects and display them in activity_projects
 */
public class ProjectActivity extends AppCompatActivity implements RecyclerViewAdapter.OnProjectListener {

    private List<Project> projectList;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private Button btnAddP;
    private EditText etAddP;

    /**
     * opens activity_projects, creates a list of projects, builds a recycler view and sets the needed button to add a new project
     * further information in AppCompatActivity
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        setContentView(R.layout.activity_projects);

        createProjectList();
        buildRecyclerView();
        setButtons();
    }

    /**
     * method setting up button to add a new project
     * After writing the name of the project and clicking on the button, the project will be added.
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
     * method building recyclerview
     */
    private void buildRecyclerView() {
        // set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerViewProjects);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(this, projectList, this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }


    /**
     * method creating a list of projects
     */
    private void createProjectList() {
        projectList = new ArrayList<>();
        projectList.add(new Project ("Time Manager", "App, die das Zeitmanagement vereinfacht.", 11.1, "grün"));
        projectList.add(new Project ("Vier gewinnt", "Spiel für zwei Personen.", 12.1, "rot"));
        projectList.add(new Project ( "Offenes Notitzbuch", "Das Notizbuch für die ganze Firma.", 13.1, "grün"));
        projectList.add(new Project ( "Bookend", "Digitaler Buchclub.", 14.1, "lila"));
        projectList.add(new Project ("RezepteToGo", "Alle Rezepte auf jedem Gerät.", 15.1, "gelb"));
    }

    /**
     * implemented method to start ProjectDetailActivity (the overview of each project) by clicking on the specific project in the recycler view
     * @param project clicked project
     */
    @Override
    public void onProjectClick(Project project) {
        startActivity(new Intent(ProjectActivity.this, ProjectDetailActivity.class).putExtra("data", project));

    }
}
