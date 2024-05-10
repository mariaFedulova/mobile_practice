package ru.mirea.fedulovama.lesson6;

import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.fedulovama.lesson6.databinding.ActivityMainBinding;

import android.content.Context;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    TextInputEditText group;
    TextInputEditText number;
    TextInputEditText film;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	=	ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        group = binding.group;
        number = binding.number;
        film = binding.film;
        SharedPreferences	sharedPref	= getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
        String _group = sharedPref.getString("GROUP", "Группа не указана");
        String _number = sharedPref.getString("NUMBER", "Номер не указан");
        String _film = sharedPref.getString("FILM", "Фильм не указан");
        group.setText(_group);
        number.setText(_number);
        film.setText(_film);
        binding.toSaveButton.setOnClickListener(new	View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor	editor	=	sharedPref.edit();
                editor.putString("GROUP", group.getText().toString());
                editor.putString("NUMBER", number.getText().toString());
                editor.putString("FILM", film.getText().toString());
                editor.apply();
            }
        });
    }
}