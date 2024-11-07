package ru.mirea.fedulovama.data.storage.sharedprefs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.time.LocalDate;

import ru.mirea.fedulovama.data.storage.MovieStorage;
import ru.mirea.fedulovama.data.storage.models.Movie;

public class SharedPrefMovieStorage implements MovieStorage {
    private static final String SHARED_PREFS_NAME = "shared_prefs_name";
    private static final String KEY = "movie_name";
    private static final String DATE_KEY = "movie_date";
    private static final String ID_KEY = "movie_id";
    private SharedPreferences sharedPreferences;
    private Context context;
    public SharedPrefMovieStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME,
                Context.MODE_PRIVATE);
    }
    @Override
    public Movie get() {
        String movieName = sharedPreferences.getString(KEY, "unknown");
        String movieDate = sharedPreferences.getString(DATE_KEY,
                String.valueOf(LocalDate.now()));
        int movieId = sharedPreferences.getInt(ID_KEY, -1);
        return new Movie(movieId, movieName, movieDate);
    }
    @SuppressLint("CommitPrefEdits")
    @Override
    public boolean save(Movie movie) {
        sharedPreferences.edit()
                .putString(KEY, movie.getName())
                .putString(DATE_KEY, String.valueOf(LocalDate.now()))
                .putInt(ID_KEY, 1)
                .apply();
        return true;
    }
}