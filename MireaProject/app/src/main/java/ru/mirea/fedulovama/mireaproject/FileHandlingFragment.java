package ru.mirea.fedulovama.mireaproject;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class FileHandlingFragment extends Fragment {
    private static final int REQUEST_CODE_PERMISSIONS = 1;
    public static final int PICK_FILE_REQUEST_CODE = 1001;
    private Uri selectedFileUri;
    FloatingActionButton addFileButton;
    Button writeButton;

    public FileHandlingFragment() {
        // Required empty public constructor
    }

    public static FileHandlingFragment newInstance(String param1, String param2) {
        FileHandlingFragment fragment = new FileHandlingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!= null) {
            selectedFileUri = savedInstanceState.getParcelable("selectedFileUri");
        }
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (selectedFileUri!= null) {
            outState.putParcelable("selectedFileUri", selectedFileUri);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_file_handling, container, false);
        addFileButton = view.findViewById(R.id.floatingActionButton);
        writeButton = view.findViewById(R.id.writeButton);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        int	writePermissionStatus	=	ContextCompat.checkSelfPermission(getContext(),	android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int	readPermissionStatus	=	ContextCompat.checkSelfPermission(getContext(),	android.Manifest.permission.READ_EXTERNAL_STORAGE);
        if(writePermissionStatus != PackageManager.PERMISSION_GRANTED || readPermissionStatus != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),	new	String[]	{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE},	REQUEST_CODE_PERMISSIONS);
        }
        addFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickFile();
            }
        });
    }
    private void pickFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, PICK_FILE_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data!= null) {
            selectedFileUri = data.getData();
            showInputDialog();
        }
    }

    private void showInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Введите название файла");
        builder.setMessage("Введите название файла, под которым вы хотите сохранить выбранный файл.");
        final EditText input = new EditText(getContext());
        builder.setView(input);
        builder.setPositiveButton("OK", (dialog, id) -> {
            String filename = input.getText().toString();
            if (selectedFileUri!= null) {
                try {
                    InputStream inputStream = getContext().getContentResolver().openInputStream(selectedFileUri);
                    OutputStream outputStream = new FileOutputStream(new File(getContext().getFilesDir(), filename));
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer))!= -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    inputStream.close();
                    outputStream.flush();
                    outputStream.close();
                    Toast.makeText(getContext(), "Файл сохранен под названием: " + filename, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton("Отмена", (dialog, id) -> dialog.cancel());
        builder.show();
    }

}