package ru.mirea.fedulovama.sharer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newActivity(View view){
        Intent intent = new Intent(this, ShareActivity.class);
        startActivity(intent);
    }

    public void newPickActivity(View view){
        Intent intent = new Intent(this, ShareActivity2.class);
        startActivity(intent);
    }
}