package com.example.timemanager.ui.settings;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.timemanager.R;
import com.example.timemanager.ui.home.HomeFragment;
import com.example.timemanager.ui.projects.Project;

import java.util.ArrayList;
import java.util.List;

import lib.folderpicker.FolderPicker;

public class SettingsFragment extends Fragment {

    private List<Project> projectList;
    private String filePath;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        filePath = root.getContext().getFilesDir().toString();
        //final TextView textView = root.findViewById(R.id.settingsText);
        Button searchButton = (Button) root.findViewById(R.id.btn_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedSearchButton(v);
            }
        });
        Button btnsave = (Button) root.findViewById(R.id.btn_save);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeFragment.class);
                startActivity(intent);
            }
        });
        return root;
    }


    /**
     * with click on the button you can pick a folder from the Device (not every folder can be picked)
     * @param v
     */
    public void clickedSearchButton(View v){
        Intent pathPicker = new Intent(this.getActivity(), FolderPicker.class);
        startActivityForResult(pathPicker, 10);
    }

    /**
     * writes a new XML-Data
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

        projectList = new ArrayList<>();
        //plannedHours in double umwandeln??
        projectList.add(new Project ("Projekt1", "kurzbeschreibung 1", 11.1, "blue"));
        projectList.add(new Project ("Projekt2", "kurzbeschreibung 2", 12.1, "blue"));
        projectList.add(new Project ("Projekt3", "kurzbeschreibung 3", 13.1, "blue"));
        projectList.add(new Project ("Projekt4", "kurzbeschreibung 4", 14.1, "blue"));
        projectList.add(new Project ("Projekt5", "kurzbeschreibung 5", 15.1, "blue"));
        projectList.add(new Project ("Projekt6", "kurzbeschreibung 6", 16.1, "blue"));
        storageXML writer = new storageXML();
        filePath = data.getExtras().getString("data");
        try {
            writer.writeConfigFile(projectList, filePath);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }


}