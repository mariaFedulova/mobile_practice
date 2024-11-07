package ru.mirea.fedulovama.movieproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.fedulovama.data.repository.MovieRepositoryImpl;
import ru.mirea.fedulovama.data.storage.MovieStorage;
import ru.mirea.fedulovama.data.storage.sharedprefs.SharedPrefMovieStorage;
import ru.mirea.fedulovama.domain.models.Movie;
import ru.mirea.fedulovama.domain.repository.MovieRepository;
import ru.mirea.fedulovama.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.fedulovama.domain.usecases.SaveFilmToFavoriteUseCase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MainViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.editTextMovie);
        TextView textView = findViewById(R.id.textViewMovie);

        vm = new ViewModelProvider(this, new ViewModelFactory(this)).get(MainViewModel.class);

        vm.getFavoriteMovie().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        findViewById(R.id.buttonSaveMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.setText(new Movie(2, text.getText().toString()));
            }
        });

        findViewById(R.id.buttonGetMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.getText();
            }
        });
        Log.d(MainActivity.class.getSimpleName().toString(), "MainActivity created");
    }
}