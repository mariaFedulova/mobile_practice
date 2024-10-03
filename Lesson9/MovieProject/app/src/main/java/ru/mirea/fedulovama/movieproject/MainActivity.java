package ru.mirea.fedulovama.movieproject;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.fedulovama.movieproject.data.repository.MovieRepositoryImpl;
import ru.mirea.fedulovama.movieproject.domain.models.Movie;
import ru.mirea.fedulovama.movieproject.domain.repository.MovieRepository;
import ru.mirea.fedulovama.movieproject.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.fedulovama.movieproject.domain.usecases.SaveFilmToFavoriteUseCase;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText text = findViewById(R.id.editTextMovie);
        TextView textView = findViewById(R.id.textViewMovie);
        MovieRepository movieRepository = new MovieRepositoryImpl(getApplicationContext());
        findViewById(R.id.buttonSaveMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean result = new SaveFilmToFavoriteUseCase(movieRepository).execute(new Movie(2, text.getText().toString()));
                textView.setText(String.format("Save result %s", result));
            }
        });
        findViewById(R.id.buttonGetMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();
                textView.setText(String.format("Save result %s", movie.getName()));
            }
        });
    }
}