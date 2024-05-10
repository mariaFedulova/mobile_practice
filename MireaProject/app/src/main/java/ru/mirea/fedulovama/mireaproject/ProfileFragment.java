package ru.mirea.fedulovama.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class ProfileFragment extends Fragment {
    private TextInputEditText nameInput;
    private TextInputEditText lastNameInput;
    private TextInputEditText emailInput;
    private TextInputEditText seriesInput;
    private Button loadButton;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        nameInput = view.findViewById(R.id.nameInput);
        lastNameInput = view.findViewById(R.id.lastNameInput);
        emailInput = view.findViewById(R.id.emailInput);
        seriesInput = view.findViewById(R.id.seriesInput);
        loadButton = view.findViewById(R.id.loadButton);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        SharedPreferences sharedPref = getActivity().getSharedPreferences("profile_settings", Context.MODE_PRIVATE);
        String name = sharedPref.getString("NAME", "Имя не указано");
        String lastName = sharedPref.getString("LASTNAME", "Фамилия не указана");
        String email = sharedPref.getString("EMAIL", "Email не указан");
        String series = sharedPref.getString("SERIES", "Сериал не указан");
        nameInput.setText(name);
        lastNameInput.setText(lastName);
        emailInput.setText(email);
        seriesInput.setText(series);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor	editor	=	sharedPref.edit();
                editor.putString("NAME", nameInput.getText().toString());
                editor.putString("LASTNAME", lastNameInput.getText().toString());
                editor.putString("EMAIL", emailInput.getText().toString());
                editor.putString("SERIES", seriesInput.getText().toString());
                editor.apply();
            }
        });
    }
}