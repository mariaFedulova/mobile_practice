package ru.mirea.fedulovama.notebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import ru.mirea.fedulovama.notebook.databinding.ActivityMainBinding;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    TextInputEditText fileNameInput;
    TextInputEditText quoteInput;
    private static final int REQUEST_CODE_PERMISSIONS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fileNameInput = binding.file;
        quoteInput = binding.quote;
        int	writePermissionStatus	=	ContextCompat.checkSelfPermission(this,	Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int	readPermissionStatus	=	ContextCompat.checkSelfPermission(this,	Manifest.permission.READ_EXTERNAL_STORAGE);
        if(writePermissionStatus != PackageManager.PERMISSION_GRANTED || readPermissionStatus != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,	new	String[]	{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE},	REQUEST_CODE_PERMISSIONS);
        }
        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = fileNameInput.getText().toString();
                String quote = quoteInput.getText().toString();
                writeFileToExternalStorage(fileName, quote);
            }
        });

        binding.loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = fileNameInput.getText().toString();
                List<String> lines = readFileFromExternalStorage(fileName);
                lines.forEach((line) -> quoteInput.append(line));
            }
        });
    }
    public	void	writeFileToExternalStorage(String fileName, String data)	{
        File path =	Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file =	new	File(path,	fileName);
        try	{
            FileOutputStream fileOutputStream	=	new	FileOutputStream(file.getAbsoluteFile());
            OutputStreamWriter output	=	new	OutputStreamWriter(fileOutputStream);
            output.write(data);
            output.close();
        }	catch	(IOException e)	{
            Log.w("ExternalStorage",	"Error	writing	"	+	file,	e);
        }
    }
    public	List<String>	readFileFromExternalStorage(String fileName)	{
        File path =	Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS);
        File file =	new	File(path,	fileName);
        List<String> lines	=	new ArrayList<String>();
        try	{
            FileInputStream fileInputStream	=	new	FileInputStream(file.getAbsoluteFile());
            InputStreamReader inputStreamReader	=	new	InputStreamReader(fileInputStream,	StandardCharsets.UTF_8);
            BufferedReader reader	=	new	BufferedReader(inputStreamReader);
            String	line	=	reader.readLine();
            while	(line	!=	null)	{
                lines.add(line);
                line	=	reader.readLine();
            }
            Log.w("ExternalStorage",	String.format("Read	from file %s successful", lines.toString()));
        }	catch	(Exception	e)	{
            Log.w("ExternalStorage",	String.format("Read	from file %s failed", e.getMessage()));
        }
        return lines;
    }
    private void requestPermissions() {
        String[] permissions = {
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_PERMISSIONS);
    }
}