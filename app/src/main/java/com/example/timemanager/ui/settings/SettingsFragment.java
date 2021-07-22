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

/**
 * class needed to open the fragment_settings including the functionality to set a location where data can be saved
 */
public class SettingsFragment extends Fragment {

    private List<Project> projectList;
    private String filePath;

    /**
     * opens fragment_settings and contains functionality behind the buttons search and save.
     * After clicking on btnsave the user gets redirected to HomeFragment.
     * further information in implemented Parcelable
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        filePath = view.getContext().getFilesDir().toString();

        Button searchButton = (Button) view.findViewById(R.id.btn_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedSearchButton(v);
            }
        });

        Button btnsave = (Button) view.findViewById(R.id.btn_save);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeFragment.class);
                startActivity(intent);
            }
        });

        return view;
    }


    /**
     * with click on the button you can pick a folder from the device (not every folder can be picked)
     * @param v current view
     */
    public void clickedSearchButton(View v){
        Intent pathPicker = new Intent(this.getActivity(), FolderPicker.class);
        startActivityForResult(pathPicker, 10);
    }

    /**
     * creates a list of projects which are stored in a XML-file and saved at the chosen location
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        projectList = new ArrayList<>();
        projectList.add(new Project ("Time Manager", "App, die das Zeitmanagement vereinfacht.", 11.1, "grün"));
        projectList.add(new Project ("Vier gewinnt", "Spiel für zwei Personen.", 12.1, "rot"));
        projectList.add(new Project ( "Offenes Notitzbuch", "Das Notizbuch für die ganze Firma.", 13.1, "grün"));
        projectList.add(new Project ( "Bookend", "Digitaler Buchclub.", 14.1, "lila"));
        projectList.add(new Project ("RezepteToGo", "Alle Rezepte auf jedem Gerät.", 15.1, "gelb"));
        StorageXML writer = new StorageXML();
        filePath = data.getExtras().getString("data");
        try { writer.writeConfigFile(projectList, filePath); }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }


}