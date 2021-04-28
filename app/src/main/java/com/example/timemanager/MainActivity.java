package com.example.timemanager;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.util.Log;


import com.example.timemanager.ui.projects.Project;
import com.example.timemanager.ui.recycler.RecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_info, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //data to populate recycle view
        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project ("Projekt1", "kurzbeschreibung 1", 11.1, "blue"));
        projectList.add(new Project ("Projekt2", "kurzbeschreibung 2", 12.1, "blue"));
        projectList.add(new Project ("Projekt3", "kurzbeschreibung 3", 13.1, "blue"));
        projectList.add(new Project ("Projekt4", "kurzbeschreibung 4", 14.1, "blue"));
        projectList.add(new Project ("Projekt5", "kurzbeschreibung 5", 15.1, "blue"));
        projectList.add(new Project ("Projekt6", "kurzbeschreibung 6", 16.1, "blue"));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewAdapter(projectList));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }


    public void handleText(View v){

        v.setEnabled(false);

        Log.d("MyLog", "message");
        Toast.makeText(this, "DELETED", Toast.LENGTH_LONG).show();
    }


}