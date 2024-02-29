package ru.mirea.fedulovama.multiactivity;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.util.Log;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    private TextView _textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String text = (String) getIntent().getSerializableExtra("key");
        _textView = findViewById(R.id.textView2);
        _textView.setText(text);
        Log.i(TAG, "SecondActivity: onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "SecondActivity: onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Log.i(TAG, "SecondActivity: onRestoreInstanceState()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG, "SecondActivity: onRestart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "SecondActivity: OnResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "SecondActivity: onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Log.i(TAG,"SecondActivity: onSaveInstanceState()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"SecondActivity: onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "SecondActivity: onDestroy()");
    }
}