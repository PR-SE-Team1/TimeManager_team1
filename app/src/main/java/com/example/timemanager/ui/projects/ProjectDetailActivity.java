package com.example.timemanager.ui.projects;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timemanager.R;
import com.example.timemanager.ui.tasks.Task;
import com.example.timemanager.ui.tasks.TaskActivity;

import java.util.ArrayList;
import java.util.List;

//zum speichern savedInstanceState

public class ProjectDetailActivity extends AppCompatActivity {

    public List<String> projectList = new ArrayList<>();
    public List<String> taskList = new ArrayList<>();
    public List<String> colorList = new ArrayList<>();

    SharedPreferences sharedPreferences;
    TextView tvProject;
    TextView editHours;;
    TextView editDescription;
    public static final String mypreference = "mypref";
    public static final String Description = "descriptionKey";
    public static final String Hours = "hoursKey";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //opening activity
        setContentView(R.layout.activity_edit_projects);

        Intent intent = getIntent();
        Project project = intent.getParcelableExtra("Projekt");

        String name = project.getProjName();
        String description = project.getDescription();

        tvProject = findViewById(R.id.selectedProject);
        tvProject.setText(name);

//        //---- getting Project
//        tvProject = findViewById(R.id.selectedProject);
//        Intent intent = getIntent();
//        if (intent.getExtras() != null){
//            Project project = (Project) intent.getParcelableExtra("data");
//            tvProject.setText(project.getProjName());
//        }
//
//        editDescription = findViewById(R.id.mltEditDescription);
//        Intent intent2 = getIntent();
//        if (intent2.getExtras() != null){
//            Project project = (Project) intent.getParcelableExtra("data");
//            //editDescription.setText(project.getDescription());
//        }


//        //editText PROJECT
//        editDescription = (TextView) findViewById(R.id.mltEditDescription);
//        editHours = (TextView) findViewById(R.id.ptEditHours);
//        sharedPreferences = getSharedPreferences(mypreference,
//                Context.MODE_PRIVATE);
//        if (sharedPreferences.contains(Description)) {
//            editDescription.setText(sharedPreferences.getString(Description, ""));
//        }
//        if (sharedPreferences.contains(Hours)) {
//            editHours.setText(sharedPreferences.getString(Hours, ""));
//
//        }

//        // spinner edit PROJECT
//        projectList.add(new Project ("Projekt1", "kurzbeschreibung 1", 11.1, "blue").getProjName());
//        projectList.add(new Project ( "Projekt2", "kurzbeschreibung 2", 12.1, "blue").getProjName());
//        projectList.add(new Project ( "Projekt3", "kurzbeschreibung 3", 13.1, "blue").getProjName());
//        Spinner spinnerP;
//        spinnerP = findViewById(R.id.spinnerEditChangeProj);
//        ArrayAdapter arrayAdapterP = new ArrayAdapter(this,android.R.layout.simple_spinner_item,projectList);
//        arrayAdapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerP.setAdapter(arrayAdapterP);


        //spinner edit TASK
        taskList.add(new Task("Aufgabe1").getTaskName());
        taskList.add(new Task("Aufgabe2").getTaskName());
        Spinner spinnerT;
        spinnerT = findViewById(R.id.spinnerEditDefTask);
        ArrayAdapter arrayAdapterT = new ArrayAdapter(this,android.R.layout.simple_spinner_item,taskList);
        arrayAdapterT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerT.setAdapter(arrayAdapterT);

        //spinner edit COLOR
        colorList.add("BLAU");
        colorList.add("ROT");
        colorList.add("GRÜN");
        Spinner spinnerC;
        spinnerC = findViewById(R.id.spinnerEditColor);
        ArrayAdapter arrayAdapterC = new ArrayAdapter(this,android.R.layout.simple_spinner_item,colorList);
        arrayAdapterC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerC.setAdapter(arrayAdapterC);

    }

    public void save(View view) {
        String savedDescription = editDescription.getText().toString();
        String savedHours = editHours.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Description, savedDescription);
        editor.putString(Hours, savedHours);
        editor.commit();
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
    }

}
