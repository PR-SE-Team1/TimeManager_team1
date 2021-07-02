package com.example.timemanager.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.timemanager.R;
import com.example.timemanager.ui.home.HomeFragment;
import com.example.timemanager.ui.projects.Project;

import java.util.ArrayList;
import java.util.List;

import lib.folderpicker.FolderPicker;

public class SettingsFragment extends Fragment {

    private SettingsViewModel notificationsViewModel;
    private List<Project> projectList;
    private String filePath;
    private String targetHours;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        filePath = root.getContext().getFilesDir().toString();
        final TextView textView = root.findViewById(R.id.settingsText);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
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


    public void handleTargetHours(View v){
        TextView t = null;
        t = t.findViewById(R.id.tv_targetHours);
        targetHours = t.getText().toString();
        //String input = t.getText().toString();
        //Log.d("target hour", input);

    }

    public String getTargetHours(){
        return targetHours;
    }



//    public void clickedSearchButton(View v) {
//        projectList = new ArrayList<>();
//        projectList.add(new Project (1,"Projekt1", "kurzbeschreibung 1", 11.1, "blue"));
//        projectList.add(new Project (2,"Projekt2", "kurzbeschreibung 2", 12.1, "blue"));
//        projectList.add(new Project (3,"Projekt3", "kurzbeschreibung 3", 13.1, "blue"));
//        projectList.add(new Project (4,"Projekt4", "kurzbeschreibung 4", 14.1, "blue"));
//        projectList.add(new Project (5,"Projekt5", "kurzbeschreibung 5", 15.1, "blue"));
//        projectList.add(new Project (6,"Projekt6", "kurzbeschreibung 6", 16.1, "blue"));
//        storageXML writer = new storageXML();
//        try {
//            writer.writeConfigFile(projectList, filePath);
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//    }

    public void clickedSearchButton(View v){
        Intent pathPicker = new Intent(this.getActivity(), FolderPicker.class);
        startActivityForResult(pathPicker, 10);
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        projectList = new ArrayList<>();
        projectList.add(new Project (1,"Projekt1", "kurzbeschreibung 1", 11.1, "blue"));
        projectList.add(new Project (2,"Projekt2", "kurzbeschreibung 2", 12.1, "blue"));
        projectList.add(new Project (3,"Projekt3", "kurzbeschreibung 3", 13.1, "blue"));
        projectList.add(new Project (4,"Projekt4", "kurzbeschreibung 4", 14.1, "blue"));
        projectList.add(new Project (5,"Projekt5", "kurzbeschreibung 5", 15.1, "blue"));
        projectList.add(new Project (6,"Projekt6", "kurzbeschreibung 6", 16.1, "blue"));
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