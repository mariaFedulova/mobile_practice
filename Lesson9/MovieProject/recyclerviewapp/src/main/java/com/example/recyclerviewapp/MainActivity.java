package com.example.recyclerviewapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<HistoricalEvent> events = getListData();
        RecyclerView recyclerView = this.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new HistoricalEventRecyclerViewAdapter(events));
        // RecyclerView scroll vertical
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }
    private List<HistoricalEvent> getListData() {
        List<HistoricalEvent> list = new ArrayList<HistoricalEvent>();
        HistoricalEvent frenchRevolution = new HistoricalEvent("Великая французская революция", "prise_de_la_bastille", "1789-1799");
        list.add(frenchRevolution);
        return list;
    }
}