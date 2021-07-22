package com.example.timemanager.ui.projects;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timemanager.R;
import com.example.timemanager.ui.tasks.Task;
import com.example.timemanager.ui.tasks.TaskActivity;

import java.util.ArrayList;
import java.util.List;


public class ProjectDetailActivity extends AppCompatActivity {

    public List<String> projectList = new ArrayList<>();
    public List<String> taskList = new ArrayList<>();
    public List<String> colorList = new ArrayList<>();

    SharedPreferences sharedPreferences;

    TextView tvProject;
    TextView editHours;
    TextView editDescription;

    public static final String mypreference = "mypreference"; //nochmal kontrolieren ob mypref wo steht
    public static final String Description = "descriptionKey";//sonarqube will das Key weg haben
    public static final String Hours = "hoursKey";// -"-

    public Project project = new Project("Project1", "Beschreibung", 28, "red");


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //opening activity
        setContentView(R.layout.activity_edit_projects);


        //---- getting Project
        tvProject = findViewById(R.id.selectedProject);
        editDescription = findViewById(R.id.mltEditDescription);
        editHours = findViewById(R.id.ptEditHours);
        Intent intent1 = getIntent();
        if (intent1.getExtras() != null){
            Project project = (Project) intent1.getParcelableExtra("data");
            tvProject.setText(project.getProjName());
            editDescription.setText(project.getDescription());
            double d = project.getPlannedHours();
            editHours.setText(String.valueOf(d));
        }


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
        taskList.add(new Task("Aufgabe1", true, project).getTaskName());
        taskList.add(new Task("Aufgabe2", false, project).getTaskName());
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

    /**
     * saves the details of the project
     * @param view
     */
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
    }//entfernen?

}
