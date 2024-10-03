package ru.mirea.fedulovama.movieproject.data.repository;

import android.content.Context;
import android.content.SharedPreferences;

import ru.mirea.fedulovama.movieproject.domain.models.Movie;
import ru.mirea.fedulovama.movieproject.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {
    Context context;

    public MovieRepositoryImpl(Context context){
        this.context = context;
    }

    public boolean saveMovie(Movie movie){
        SharedPreferences movieSettings = context.getSharedPreferences("movie", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = movieSettings.edit();
        editor.putString("movie", movie.getName());
        editor.apply();
        return true;
    }
    public Movie getMovie(){
        SharedPreferences movieSettings = context.getSharedPreferences("movie", Context.MODE_PRIVATE);
        return new Movie(1, movieSettings.getString("movie", ""));
    }
}
