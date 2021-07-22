package com.example.timemanager.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.timemanager.R;
import com.example.timemanager.ui.projects.Project;
import com.example.timemanager.ui.projects.ProjectActivity;
import com.example.timemanager.ui.tasks.TaskActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = "ProjectActivity";
    View v;
    private List<Project> projectList;
    private Button btnProjects;
    private Button btnTasks;
    //sollten initialisiert werden

    /**
     * constructor for code quality
     */
    public HomeFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnProjects = (Button) view.findViewById(R.id.btnProjects);
        btnProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProjectActivity.class);
                startActivity(intent);
            }
        });

        btnTasks = (Button) v.findViewById(R.id.btnTasks);
        btnTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TaskActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }

    /**
     * creates a List of Projects
     */
    public void createProjectList(){
        double plannedHours = 11.1; //sonarqube will das so
        double plannedHours2 = 12.1;
        double plannedHours3 = 13.1;
        double plannedHours4 = 14.1;
        double plannedHours5 = 15.1;
        projectList = new ArrayList<>();
        projectList.add(new Project ("Projekt1", "kurzbeschreibung 1", plannedHours, "blue"));
        projectList.add(new Project ("Projekt2", "kurzbeschreibung 2", plannedHours2, "blue"));
        projectList.add(new Project ( "Projekt3", "kurzbeschreibung 3", plannedHours3, "blue"));
        projectList.add(new Project ( "Projekt4", "kurzbeschreibung 4", plannedHours4, "blue"));
        projectList.add(new Project ("Projekt5", "kurzbeschreibung 5", plannedHours5, "blue"));

    }

    @Override
    public void onClick(View v) {
        //entweder löschen oder was hinzufügen
    }
}