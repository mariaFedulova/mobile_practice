package ru.mirea.fedulovama.control_lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView myTextView = findViewById(R.id.textView);
        myTextView.setText("Картинков вставили зачем-то");
        Button button = findViewById(R.id.button5);
        button.setText("News");

    }
}