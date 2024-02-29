package ru.mirea.fedulovama.multiactivity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText _textElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _textElement = findViewById(R.id.textInputLayout);
        Log.i(TAG, "FirstActivity: onCreate()");
    }

    public void onClickNewActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String _text;
        if (_textElement.getText() != null) _text = _textElement.getText().toString();
        else _text = "";
        intent.putExtra("key", _text);
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "FirstActivity: onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Log.i(TAG, "FirstActivity: onRestoreInstanceState()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG, "FirstActivity: onRestart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "FirstActivity: OnResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "FirstActivity: onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Log.i(TAG,"FirstActivity: onSaveInstanceState()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"FirstActivity: onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "FirstActivity: onDestroy()");
    }
}