package com.example.listviewapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String[] countries = { "Ремарк - Триумфальная арка", "Стругацкие - Понедельник начинается в субботу", "Хаксли - О дивный новый мир",
            "Толстой - Война и мир", "Киз - Цветы для Элджернона", "Достоевский - Идиот", "Зюскинд - Парфюмер", "Пастернак - Доктор Живаго",
            "Фаулз - Коллекционер", "Митчелл - Унесенные ветром", "Мураками - Мужчины без женщин", "Брэдбери - Вино из одуванчиков", "Харрис - Красный дракон", "Гейман, Пратчетт - Благие знамения"};

    ListView countriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        countriesList = findViewById(R.id.country_list_view);

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_2, android.R.id.text1, countries) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                View view = super.getView(position, convertView, parent);
                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);
                text2.setText(getItem(position).toString());
                text1.setText(String.valueOf(position+1));
                return view;
            }
        };

        countriesList.setAdapter(adapter);
    }
}