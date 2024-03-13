package ru.mirea.fedulovama.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.text.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    long dateInMillis;
    String format = "yyyy-MM-dd HH:mm:ss";
    final SimpleDateFormat sdf = new SimpleDateFormat(format);
    String dateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void postTime(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        dateInMillis = System.currentTimeMillis();
        dateString = sdf.format(new Date(dateInMillis));
        intent.putExtra("date", dateString);
        startActivity(intent);
    }
}