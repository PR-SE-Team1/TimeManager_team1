package com.example.timemanager.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.timemanager.R;
import com.example.timemanager.ui.home.HomeFragment;
import com.example.timemanager.ui.projects.Project;

import java.util.ArrayList;
import java.util.List;

public class SettingsFragment extends Fragment {

    private SettingsViewModel notificationsViewModel;
    private List<Project> projectList;
    private String filePath;
    private String targetHours;
    private Button btnsave;




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

        btnsave = (Button) root.findViewById(R.id.btn_save);
        btnsave.setOnClickListener(v1 -> {
            FragmentTransaction ft = getParentFragmentManager().beginTransaction();
            ft.replace(this.getId(), new HomeFragment());
            ft.commit();
        });



        return root;
    }


    public void handleTargetHours(View v){
        TextView t = null;
        t = t.findViewById(R.id.tv_targetHours);
        targetHours = t.getText().toString();

    }

    public String getTargetHours(){
        return targetHours;
    }



    public void clickedSearchButton(View v) {
        projectList = new ArrayList<>();
        projectList.add(new Project ("Projekt1", "kurzbeschreibung 1", 11.1, "blue"));
        projectList.add(new Project ("Projekt2", "kurzbeschreibung 2", 12.1, "blue"));
        projectList.add(new Project ("Projekt3", "kurzbeschreibung 3", 13.1, "blue"));
        projectList.add(new Project ("Projekt4", "kurzbeschreibung 4", 14.1, "blue"));
        projectList.add(new Project ("Projekt5", "kurzbeschreibung 5", 15.1, "blue"));
        projectList.add(new Project ("Projekt6", "kurzbeschreibung 6", 16.1, "blue"));
        storageXML writer = new storageXML();
        try {
            writer.writeConfigFile(projectList, filePath);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

}