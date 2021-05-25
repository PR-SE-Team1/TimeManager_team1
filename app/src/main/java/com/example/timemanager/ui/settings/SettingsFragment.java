package com.example.timemanager.ui.settings;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.timemanager.R;

public class SettingsFragment extends Fragment {

    private SettingsViewModel notificationsViewModel;

    int hours;

    EditText hoursInput;

    Button saveButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        hoursInput = (EditText) hoursInput.findViewById(R.id.et_targetHours);

        saveButton = (Button) saveButton.findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                hours = Integer.valueOf(hoursInput.getText().toString());

                showToast(String.valueOf(hours));
            }
        });

        notificationsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        final TextView textView = root.findViewById(R.id.settingsText);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;

    }

    private void showToast(String text){
        Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
    }

}