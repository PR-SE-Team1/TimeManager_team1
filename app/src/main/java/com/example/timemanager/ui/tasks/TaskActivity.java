package com.example.timemanager.ui.tasks;

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

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    //public List<String> taskList = new ArrayList<>();
    private RecyclerView recyclerView;
    private List<Task> taskList;

    TaskActivity ta;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        taskList = new ArrayList<>();
        taskList.add(new Task("Aufgabe1", new Project(11, "Projekt11", "kurzbeschreibung 11", 11.1, "blue"), true));
        taskList.add(new Task("Aufgabe2", new Project(12, "Projekt12", "kurzbeschreibung 12", 11.1, "blue"), false));



    }

//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//
//        View v = inflater.inflate(R.layout.recycler_item_view_tasks, container, false);
//        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),projectList, this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(recyclerViewAdapter);
//
//        addButton = (Button) v.findViewById(R.id.add_project);
//        addButton.setOnClickListener(v1 -> {
//            FragmentTransaction ft = getParentFragmentManager().beginTransaction();
//            ft.replace(R.id.nav_host_fragment, new ProjectNew());
//            ft.commit();
//        });
//        return v;
//
//    }
}

