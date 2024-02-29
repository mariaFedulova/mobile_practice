package ru.mirea.fedulovama.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMessage(View view){
        editText = findViewById(R.id.textInputEditText);
        String _text;
        if (editText.getText() != null) _text = editText.getText().toString();
        else _text = "";
        int count = _text.length();
        Toast toast = Toast.makeText(getApplicationContext(),
                "СТУДЕНТ № 26 ГРУППА БСБО-10-21 Количество символов - " + count,
                Toast.LENGTH_LONG);
        toast.show();
    }
}