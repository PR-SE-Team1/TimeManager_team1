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

/**
 * opens activity_edit_project, shows details about a project
 */
public class ProjectDetailActivity extends AppCompatActivity {

    public List<String> taskList = new ArrayList<>();
    public List<String> colorList = new ArrayList<>();

    SharedPreferences sharedPreferences;

    TextView tvProject;
    TextView editHours;
    TextView editDescription;

    public static final String Description = "descriptionKey";
    public static final String Hours = "hoursKey";

    public Project project = new Project("Project1", "Beschreibung", 28, "red");

    /**
     * opens activity_edit_projects and contains the implementation to display only details from the clicked project.
     * The name of the project and the short description are displayed in a TextView and the defauls task and color can be changed in a spinner
     * further information in AppCompatActivity
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_projects);

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

        taskList.add(new Task("Arbeit aufteilen", true, project).getTaskName());
        taskList.add(new Task("Gruppen bilden", false, project).getTaskName());
        Spinner spinnerT;
        spinnerT = findViewById(R.id.spinnerEditDefTask);
        ArrayAdapter arrayAdapterT = new ArrayAdapter(this,android.R.layout.simple_spinner_item,taskList);
        arrayAdapterT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerT.setAdapter(arrayAdapterT);

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
     * saves the details of the project on button click
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

    /**
     * opens TaskActivity on button click
     * @param view
     */
    public void goToActivities(View view) {
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
    }

}
