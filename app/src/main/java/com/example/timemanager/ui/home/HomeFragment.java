package com.example.timemanager.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timemanager.R;
import com.example.timemanager.ui.projects.Project;
import com.example.timemanager.ui.projects.ProjectActivity;
import com.example.timemanager.ui.projects.ProjectNew;
import com.example.timemanager.ui.recycler.RecyclerViewAdapter;
import com.example.timemanager.ui.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = "ProjectActivity";
    private HomeViewModel homeViewModel;
    View v;
    private List<Project> projectList;
    private Button btnProjects;

    //chronometer
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        //inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        btnProjects = (Button) v.findViewById(R.id.btnProjects);
        btnProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProjectActivity.class);
                startActivity(intent);
            }

        });




        return v;

    }




    public void createProjectList(){
        projectList = new ArrayList<>();
        projectList.add(new Project ("Projekt1", "kurzbeschreibung 1", 11.1, "blue"));
        projectList.add(new Project ("Projekt2", "kurzbeschreibung 2", 12.1, "blue"));
        projectList.add(new Project ( "Projekt3", "kurzbeschreibung 3", 13.1, "blue"));
        projectList.add(new Project ( "Projekt4", "kurzbeschreibung 4", 14.1, "blue"));
        projectList.add(new Project ("Projekt5", "kurzbeschreibung 5", 15.1, "blue"));

    }

    @Override
    public void onClick(View v) {

    }
}