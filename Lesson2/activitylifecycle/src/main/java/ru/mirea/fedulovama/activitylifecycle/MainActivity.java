package ru.mirea.fedulovama.activitylifecycle;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Log.i(TAG, "onRestoreInstanceState()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "OnResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Log.i(TAG,"onSaveInstanceState()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

}