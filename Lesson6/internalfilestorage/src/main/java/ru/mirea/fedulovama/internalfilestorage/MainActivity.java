package ru.mirea.fedulovama.internalfilestorage;

import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.fedulovama.internalfilestorage.databinding.ActivityMainBinding;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private String fileName = "mirea.txt";
    TextInputEditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	=	ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        input = binding.textInputEditText;
        binding.button.setOnClickListener(new	View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FileOutputStream outputStream;
                String text = input.getText().toString();
                try {
                    outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(text.getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


}