package com.example.timemanager.ui.home;

import android.content.Intent;
import android.os.Bundle;
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

public class HomeFragment extends Fragment implements RecyclerViewAdapter.OnProjectListener {

    private static final String TAG = "ProjectActivity";
    private HomeViewModel homeViewModel;
    View v;
    private RecyclerView recyclerView;
    private List<Project> projectList;
    private Button addButton;
    private Button btnAddP;
    private EditText etAddP;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createProjectList();
        buildRecyclerView();






    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),projectList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);

        addButton = (Button) v.findViewById(R.id.add_project);
        addButton.setOnClickListener(v1 -> {
            FragmentTransaction ft = getParentFragmentManager().beginTransaction();
            ft.replace(R.id.nav_host_fragment, new ProjectNew());
            ft.commit();
        });

//        btnAddP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String getInput = etAddP.getText().toString();
//
//                if (projectList.contains(getInput)){
//                    Toast.makeText(getBaseContext(), "Aufgabe existiert bereits", Toast.LENGTH_LONG).show();
//                } else if (getInput == null || getInput.trim().equals("")){
//                    Toast.makeText(getBaseContext(), "Kein Name eingegeben", Toast.LENGTH_LONG).show();
//                }else {
//                    projectList.add(new Project(getInput));
//
//                }
//            }
//        });
        return v;

    }

    /**
     * implemented to start a new activity when recycler item is clicked
     * @param position
     */
    @Override
    public void onProjectClick(int position) {
        Intent intent = new Intent(getContext(), ProjectActivity.class);
        startActivity(intent);
    }


    public void createProjectList(){
        projectList = new ArrayList<>();
        projectList.add(new Project ("Projekt1", "kurzbeschreibung 1", 11.1, "blue"));
        projectList.add(new Project ("Projekt2", "kurzbeschreibung 2", 12.1, "blue"));
        projectList.add(new Project ( "Projekt3", "kurzbeschreibung 3", 13.1, "blue"));
        projectList.add(new Project ( "Projekt4", "kurzbeschreibung 4", 14.1, "blue"));
        projectList.add(new Project ("Projekt5", "kurzbeschreibung 5", 15.1, "blue"));

    }

    public void buildRecyclerView(){

    }

}