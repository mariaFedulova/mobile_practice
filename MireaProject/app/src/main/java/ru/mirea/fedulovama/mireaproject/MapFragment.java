package ru.mirea.fedulovama.mireaproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MapFragment extends Fragment {
    TextView places;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        places = view.findViewById(R.id.places);

        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapActivity.class);
                intent.putExtra("aLatitude", 55.798229);
                intent.putExtra("aLongitude", 37.708772);
                intent.putExtra("name", "Адрес 1\nОписание 1");
                startActivity(intent);
            }
        });

        view.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapActivity.class);
                intent.putExtra("aLatitude", 55.657916);
                intent.putExtra("aLongitude", 37.475951);
                intent.putExtra("name", "Адрес 2\nОписание 2");
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        places.setText("Заведение: 1\nОписание: Описание 1\n\nЗаведение: 2\nОписание: Описание 2");
    }
}